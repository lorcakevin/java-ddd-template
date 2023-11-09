package bx.cnsr.corentsu.oscor.orders.infraestructure.adapter;

import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topic="topic-testing")
    public void listen(String message) {

    }
}
