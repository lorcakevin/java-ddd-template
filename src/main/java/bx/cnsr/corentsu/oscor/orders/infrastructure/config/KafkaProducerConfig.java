package bx.cnsr.corentsu.oscor.orders.infrastructure.config;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerConfig.class);

    @Value("${manual.configuration.confluent.producer.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${manual.configuration.confluent.producer.properties.security.protocol}")
    private String securityProtocol;

    @Value("${manual.configuration.confluent.producer.properties.sasl.mechanism}")
    private String mechanism;

    @Value("${manual.configuration.confluent.producer.jaas.config}")
    private String kafkaJaasConfig;

    @Value("${manual.configuration.confluent.producer.retries}")
    private String retriesConfig;

    @Value("${manual.configuration.confluent.producer.acks}")
    private String acksConfig;

    @Value("${manual.configuration.confluent.producer.producer-timeout}")
    private String producerTimeoutConfig;

    @Value("${manual.configuration.confluent.producer.retry-backoff-ms}")
    private String retryBackoffMsConfig;

    @Value("${manual.configuration.confluent.producer.max-idle-ms}")
    private String maxIdleMs;

    @Bean
    public KafkaTemplate<String, String> kafkaProducerTemplate() {
        return new KafkaTemplate<>(producerConfluentFactory());
    }

    @Autowired
    private ProducerFactory<String, String> producerConfluentFactory() {
        Map<String, Object> props = new HashMap<>();

        LOGGER.info("producerTimeoutConfig: {}", producerTimeoutConfig);
        LOGGER.info("retryBackoffMsConfig: {}", retryBackoffMsConfig);
        LOGGER.info("maxIdleMs: {}", maxIdleMs);

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.RETRIES_CONFIG, retriesConfig);
        props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, producerTimeoutConfig);
        props.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, retryBackoffMsConfig);
        props.put(ProducerConfig.CONNECTIONS_MAX_IDLE_MS_CONFIG, maxIdleMs);

        props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, securityProtocol);
        props.put("sasl.jaas.config", kafkaJaasConfig);
        props.put("sasl.mechanism", mechanism);

        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.ACKS_CONFIG, acksConfig);
        return new DefaultKafkaProducerFactory<>(props);
    }

    public Map<String, Object> producerConfig() {
        ProducerFactory<String, String> producerFactory;
        producerFactory = producerConfluentFactory();
        return new HashMap<>(producerFactory.getConfigurationProperties());
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(producerConfig()));
    }
}