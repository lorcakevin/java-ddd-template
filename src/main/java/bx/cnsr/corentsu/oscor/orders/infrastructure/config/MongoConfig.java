package bx.cnsr.corentsu.oscor.orders.infrastructure.config;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Value("${mongodb.user}")
    private String username;

    @Value("${mongodb.password}")
    private String password;

    @Value("${mongodb.cluster}")
    private String cluster;

    @Value("${mongodb.database}")
    private String database;

    @Value("${mongodb.min-pool-size}")
    private int minPoolSize;

    @Value("${mongodb.max-pool-size}")
    private int maxPoolSize;

    @Value("${mongodb.retryWrites}")
    private boolean retryWrites;

    @Value("${mongodb.wValue}")
    private String wValue;

    @Value("${mongodb.readPreference}")
    private String readPreference;

    @Value("${mongodb.ssl}")
    private boolean ssl;

    @Value("${mongodb.serverSelectionTimeoutMS}")
    private int serverSelectionTimeoutMS;

    @Value("${mongodb.connectTimeoutMS}")
    private int connectTimeoutMS;

    @Value("${mongodb.maxLifeTimeMS}")
    private int maxLifeTimeMS;

    @Value("${mongodb.maxLifeTimeMS}")
    private int maxIdleTimeMS;

    @Bean
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString(
                "mongodb+srv://" + username + ":" + password + "@" + cluster + "/" + database +
                        "?retryWrites=" + retryWrites + "&w=" + wValue + "&readPreference=" + readPreference +
                        "&ssl=" + ssl +
                        "&minPoolSize=" + minPoolSize +
                        "&maxPoolSize=" + maxPoolSize +
                        "&serverSelectionTimeoutMS=" + serverSelectionTimeoutMS +
                        "&connectTimeoutMS=" + connectTimeoutMS +
                        "&maxLifeTimeMS=" + maxLifeTimeMS +
                        "&maxIdleTimeMS=" + maxIdleTimeMS
        );
        return MongoClients.create(connectionString);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), database);
    }
}
