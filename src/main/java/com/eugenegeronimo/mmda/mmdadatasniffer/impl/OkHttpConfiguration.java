package com.eugenegeronimo.mmda.mmdadatasniffer.impl;

import okhttp3.OkHttpClient;
import org.springframework.boot.json.JsonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OkHttpConfiguration {

    @Bean
    public OkHttpClient client() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // set okhttpclient properties here
        return builder.build();
    }

    @Bean
    public JsonParser jsonParser() {
        return new JsonJsonParser();
    }
}
