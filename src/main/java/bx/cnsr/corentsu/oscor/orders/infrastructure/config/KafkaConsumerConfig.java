package bx.cnsr.corentsu.oscor.orders.infrastructure.config;

import bluex.cnsr.cubicacion.exception.GenericException;
import bluex.cnsr.cubicacion.model.DataRecord;
import bluex.cnsr.cubicacion.service.KafkaProducerService;
import bluex.cnsr.cubicacion.utils.SlackUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.messaging.converter.MessageConversionException;
import org.springframework.util.StringUtils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import static java.lang.String.format;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerConfig.class);

    @Autowired
    KafkaProducerService kafkaProducerService;

    @Value("${slack.icon}")
    private String slackIcon;
    @Value("${slack.endpoint}")
    private String slackEndpoint;
    @Value("${slack.subject}")
    private String slackSubject;
    @Value("${slack.subtitle}")
    private String slackSubtitle;
    @Value("${slack.channel}")
    private String slackChannel;
    @Value("${slack.username}")
    private String slackUsername;

    @Bean
    public ConsumerAwareListenerErrorHandler errorHandler() {
        return (message, exception, consumer) -> {

            var payload = message.getPayload();
            String retryCause = null;

            if(message.getHeaders().get("bx-fail-cause") instanceof byte[] failCause) {
                retryCause = new String(failCause, StandardCharsets.UTF_8);
            }

            String strMessage = messageToJson(payload);

            //Excepción de aplicación o de negocio enviará fallo
            if (exception.getCause() instanceof GenericException ex) {
                String detailErrorMessage = format(ex.getLogFormat(), (Object[]) ex.getLogParams());

                logException(ex, payload, detailErrorMessage);
                sendFailMessage(payload, ex, retryCause, "Bussiness or Application error");

            } else if (exception.getCause() instanceof DataAccessException) { //Excepción de acceso a DB enviará reintento.

                logException(exception, payload, "[Kafka consumer connection error] No se logra conectar con la base de datos\n");
                sendRetryMessage(strMessage, retryCause, "DB Connection error");

            } else if (exception.getCause() instanceof MessageConversionException ex) { //Excepción con el procesamiento del mensaje, enviará fallo

                logException(exception, payload, "[Kafka consumer message error] No se logra interpretar el mensaje\n");
                sendFailMessage(payload, ex, retryCause, "Not valid message");
            } else { //Cualquier otra excepción enviará fallo.

                logException(exception, payload, "[Kafka consumer error] Ocurrió un error inesperado al ejecutar el consumer\n");
                sendFailMessage(payload, exception, retryCause, "Unhandled error");

            }
            return null;
        };
    }

    private void logException(Exception ex, Object payload, String detailErrorMessage) {
        String jsonMessage = messageToJson(payload);
        String bodyMessage;

        if (jsonMessage != null) {
            bodyMessage = format("[Kafka message]: %s", jsonMessage);
        } else {
            bodyMessage = format("[Kafka message (Could not serialize)]: %s", payload.toString());
        }

        String totalMessage = format("%s %s", detailErrorMessage, bodyMessage);
        logger.error(totalMessage, ex);
    }

    private void sendRetryMessage(String message,
                                  String retryCause,
                                  String cause) {

        final String causes = buildCauses(retryCause, cause);
        kafkaProducerService.sendRetry(message, causes);
    }

    private void sendFailMessage(Object message, Throwable ex, String retryCause,
                                 String failCause) {
        final String causes = buildCauses(retryCause, failCause);
        sendSlackMessage(message, failCause, ex);
        kafkaProducerService.sendFail(message.toString(), causes);
    }

    private String buildCauses(String retryCause, String cause) {
        final StringBuilder strBuilder = new StringBuilder();
        if (StringUtils.hasText(retryCause)) {
            strBuilder.append(retryCause);
        }
        strBuilder.append(cause).append("\n");
        return strBuilder.toString();
    }

    private void sendSlackMessage(Object consumerMessage, String cause, Throwable ex) {
        SlackUtils slackUtils = SlackUtils.builder()
                .slackSubject(slackSubject)
                .slackEndpoint(slackEndpoint)
                .slackSubtitle(slackSubtitle)
                .slackChannel(slackChannel)
                .slackIcon(slackIcon)
                .slackUsername(slackUsername)
                .build();

        StringBuilder message = new StringBuilder();

        message.append("⚠\uFE0F *Error en proceso de cubicación:*\n");
        message.append(String.format("\n*Causa:* %s", cause));
        message.append("\nℹ *Data:*\n");

        DataRecord dataMessage;
        if (consumerMessage instanceof DataRecord) {
            dataMessage = (DataRecord) consumerMessage;
            var data = dataMessage.getData();
            var metadata = dataMessage.getMetadata();

            if (data != null) {
                message.append(String.format("\t*- Barcode:* %s\n", data.getBarcode()));
                message.append(String.format("\t*- EEVV Id:* %s\n", data.getId()));
                message.append(String.format("\t*- Status:* %s\n", data.getStatus()));
            } else {
                message.append("\n🚫El mensaje no contiene data\n");
            }

            message.append("\nℹ *Metadata:*\n");
            if (metadata != null) {
                message.append(String.format("\t*- Transaction id:* %s\n", metadata.getTransactionId()));
                message.append(String.format("\t*- Operation:* %s\n", metadata.getOperation()));
                message.append(String.format("\t*- Record Type*: %s\n", metadata.getRecordType()));
            } else {
                message.append("\n🚫El mensaje no contiene metadata\n");
            }
        } else {
            message.append("\n🚫El mensaje no pudo ser procesado correctamente\n");
            message.append("\n\t*Mensaje recibido*:\n");
            message.append(String.format("\n\t*%s*:\n", messageToJson(consumerMessage)));
        }

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);

        String exStr = ex.getMessage() != null ? ex.getMessage() : ex.getCause().getMessage();

        message.append(String.format("\n⛔ *Excepción:* %s\n", exStr));

        slackUtils.sendSlackMessage(message.toString());
    }

    private String messageToJson(Object message) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(message).replaceAll("[\n\t\r]", "");
        } catch (Exception e) {
            return null;
        }
    }

}
