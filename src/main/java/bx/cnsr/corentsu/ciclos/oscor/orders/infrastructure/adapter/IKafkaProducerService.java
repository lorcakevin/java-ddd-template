package bx.cnsr.corentsu.ciclos.oscor.orders.infrastructure.adapter;

public interface IKafkaProducerService {
    void sendRetry(String message, String retryCause);
    void sendFail(String message, String failCause);
}
