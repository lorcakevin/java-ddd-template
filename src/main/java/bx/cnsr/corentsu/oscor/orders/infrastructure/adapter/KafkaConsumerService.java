package bx.cnsr.corentsu.oscor.orders.infrastructure.adapter;


import bx.cnsr.corentsu.oscor.orders.infrastructure.adapter.entity.DataRecord;
import org.apache.kafka.common.errors.SerializationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.converter.MessageConversionException;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class KafkaConsumerService implements IKafkaConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);


    @Value("${app.kafka.consumer.topic}")
    private String topic;

    @Value("${app.kafka.consumer.origin}")
    private Integer allowedOrigin;

    @Autowired
    private KafkaListenerEndpointRegistry registry;

    @KafkaListener(topics = "#{'${app.kafka.consumer.topic}'.split(',')}",
            errorHandler = "errorHandler")
    public void kafkaTopicListener(@Payload DataRecord message,
                                   @Header(value = "bx-fail-cause", required = false) String retryCause,
                                   @Header(value = "bx-schedule-time", required = false) String scheduleTime,
                                   Acknowledgment acknowledgment) {

        logger.info("bx-fail-cause: {}", retryCause);
        logger.info("bx-schedule-time: {}", scheduleTime);

        try {

            //Logica de validación del mensaje y llamada a
            //servicios de aplicación (casos de uso)

        } catch (BusinessException | ApplicationException |
                 DataAccessException | SerializationException |
                 MessageConversionException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ApplicationException(ExceptionCodes.APP_0001, ex,
                    "[Kafka listener] Ocurrió una excepción que impide procesar el mensaje del tópico",
                    message.toString());
        } finally {
            acknowledgment.acknowledge();
            logger.info("[Kafka Listener] Finalizando procesamiento de OS");
        }

    }

    private void processMessageDelay(String scheduleTime) {
        if (null != scheduleTime) {
            try {

                final long delay = Long.parseLong(scheduleTime) - new Date().getTime();
                if (delay > 0) {
                    registry.getListenerContainers().forEach(MessageListenerContainer::pause);
                    Thread.sleep(delay);
                    registry.getListenerContainers().forEach(MessageListenerContainer::resume);
                }

            } catch (InterruptedException ex) {
                logger.info("Ocurrió un error al procesar el delay del mensaje: {}", ex.getMessage());
                Thread.currentThread().interrupt();
                throw new ApplicationException(ExceptionCodes.APP_0001, ex, "[Kafka Listener] Ocurrió un error al procesar el delay del mensaje.");
            }
        }
    }

}
