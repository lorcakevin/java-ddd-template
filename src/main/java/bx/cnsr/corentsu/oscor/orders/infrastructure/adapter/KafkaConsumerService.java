package bx.cnsr.corentsu.oscor.orders.infrastructure.adapter;


import bluex.cnsr.cubicacion.exception.ApplicationException;
import bluex.cnsr.cubicacion.exception.BusinessException;
import bluex.cnsr.cubicacion.exception.ExceptionCodes;
import bluex.cnsr.cubicacion.model.DataRecord;
import bluex.cnsr.cubicacion.model.MetadataDetail;
import bluex.cnsr.cubicacion.model.mongo.Part;
import bluex.cnsr.cubicacion.model.oracle.TableDetail;
import bluex.cnsr.cubicacion.service.*;
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
    @Autowired
    CubicacionService cubicacionService;
    @Autowired
    PartService partService;

    @KafkaListener(topics = "#{'${app.kafka.consumer.topic}'.split(',')}",
            errorHandler = "errorHandler")
    public void kafkaTopicListener(@Payload DataRecord message,
                                   @Header(value = "bx-fail-cause", required = false) String retryCause,
                                   @Header(value = "bx-schedule-time", required = false) String scheduleTime,
                                   Acknowledgment acknowledgment) {

        logger.info("bx-fail-cause: {}", retryCause);
        logger.info("bx-schedule-time: {}", scheduleTime);

        TableDetail data = message.getData();
        MetadataDetail metadata = message.getMetadata();
        try {
            processMessageDelay(scheduleTime);
            if ((data != null && metadata != null) && metadata.getOperation().equals("insert")) {
                if(data.getOrigen() > allowedOrigin) {

                    logger.info("[Kafka Listener] [{}] Inicia proceso de cubicación", data.getBarcode());
                    Optional<Part> part = partService.getPartFromData(data);

                    part.ifPresent(value -> cubicacionService.processPart(value));
                } else {
                    logger.warn("[Kafka Listener] La configuración actual del consumer no permite cubicar el mensaje con el siguiente origen: {}", data.getOrigen());
                }
            } else {
                logger.info("[Kafka Listener] Mensaje no válido, no se procesará la orden: {}", message);
            }
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
