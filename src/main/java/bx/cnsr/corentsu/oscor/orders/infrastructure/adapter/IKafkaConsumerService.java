package bx.cnsr.corentsu.oscor.orders.infrastructure.adapter;

import bluex.cnsr.cubicacion.model.DataRecord;
import org.springframework.kafka.support.Acknowledgment;

public interface IKafkaConsumerService {

    /**
     * Consumer principal, el cual recibe un mensaje del tipo bluex.cnsr.cubicacion.model.DataRecord para iniciar el proceso de cubicación.
     *
     * @param message
     * @param retryCause
     * @param scheduleTime
     */
    void kafkaTopicListener(DataRecord message,
                            String retryCause,
                            String scheduleTime,
                            Acknowledgment acknowledgment);
}
