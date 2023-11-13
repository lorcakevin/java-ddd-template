package bx.cnsr.corentsu.oscor.orders.infrastructure.adapter;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class KafkaProducerService implements IKafkaProducerService {

    private static final Logger logger = LoggerFactory
            .getLogger(KafkaProducerService.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * Corresponde al tópico de retry que se enviará el mensaje en un reintento
     */
    @Value("${manual.configuration.confluent.topic}")
    private String retryTopic;

    /**
     * Corresponde a la cola deadletter que procesará el mensaje de error
     */
    @Value("${app.kafka.producer.fail}")
    private String fail;

    /**
     * Tiempo que se demorará en procesar el mensaje
     */
    @Value("${app.kafka.producer.retry-delay-seconds}")
    private int delay;

    /**
     * Envía un mensaje a la cola de reintentos.
     * @param message
     * @param retryCause
     */
    @Override
    public void sendRetry(String message, String retryCause) {

        final ProducerRecord<String, String> record = new ProducerRecord<>(retryTopic, message);

        record.headers().add("bx-fail-cause", retryCause.getBytes(StandardCharsets.UTF_8));

        final Long scheduleTime = new Date().getTime() + (delay * 1000L);
        record.headers().add("bx-schedule-time", String
                .valueOf(scheduleTime).getBytes(StandardCharsets.UTF_8));

        kafkaTemplate.send(record);
        kafkaTemplate.flush();
        logger.info("retryTopic sent: {}", message);
    }

    /**
     * Envía un mensaje a la cola de fallos.
     * @param message
     * @param failCause
     */
    @Override
    public void sendFail(String message, String failCause) {
        final ProducerRecord<String, String> record = new ProducerRecord<>(fail, message);

        record.headers().add("bx-fail-cause",
                failCause.getBytes(StandardCharsets.UTF_8));
        kafkaTemplate.send(record);
        logger.info("dlq sent: {}", message);
    }
}
