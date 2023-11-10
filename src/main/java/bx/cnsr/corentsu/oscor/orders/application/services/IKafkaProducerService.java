package bx.cnsr.corentsu.oscor.orders.application.services;

public interface IKafkaProducerService {
    void sendRetry(String message, String retryCause);
    void sendFail(String message, String failCause);
}
