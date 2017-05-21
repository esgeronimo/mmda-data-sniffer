package com.eugenegeronimo.mmda.mmdadatasniffer.impl.repository;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.eugenegeronimo.mmda.mmdadatasniffer.core")
public class MongoDbConfiguration extends AbstractMongoConfiguration {

    private static final String DATABASE_NAME = "mmda";

    @Value("${mongodb.server}")
    private String server;

    @Value("${mongodb.port}")
    private Integer port;

    @Override
    protected String getDatabaseName() {
        return DATABASE_NAME;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(server, port);
    }
}
