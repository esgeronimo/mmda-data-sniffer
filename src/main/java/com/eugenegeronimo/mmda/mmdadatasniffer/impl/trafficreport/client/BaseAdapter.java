package com.eugenegeronimo.mmda.mmdadatasniffer.impl.trafficreport.client;

public abstract class BaseAdapter {

    protected static final String JSON_ARRAY_FIRST_CHAR = "[";

    // The org.springframework.boot.json.JsonParser sucks! Has no method to check if input is an array of JSON
    // Don't want to have a dependency on some JSON library for that checking.
    // TODO: AdvisoriesAdapter.isJsonArray - Needs improvement on implementation
    protected boolean isJsonArray(String json) {
        return json.startsWith(JSON_ARRAY_FIRST_CHAR);
    }
}
