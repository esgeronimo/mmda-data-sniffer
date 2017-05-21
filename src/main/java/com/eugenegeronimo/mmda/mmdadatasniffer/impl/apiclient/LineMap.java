package com.eugenegeronimo.mmda.mmdadatasniffer.impl.apiclient;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Mapping line numbers to it actual location name
 */
@Component
public class LineMap {
    private static final Map<String, String> lineNameMap = new HashMap<>();

    static {
        // Line names per ID
        lineNameMap.put("1", "EDSA");
        lineNameMap.put("2", "Quezon Ave.");
        lineNameMap.put("3", "Espana");
        lineNameMap.put("4", "C5");
        lineNameMap.put("5", "Roxas Boulevard");
        lineNameMap.put("6", "SLEX");
        lineNameMap.put("7", "Commonwealth");
        lineNameMap.put("8", "Ortigas");
        lineNameMap.put("9", "Marcos Highway");
        lineNameMap.put("10", "NLEX");
    }

    public String getLineName(String lineId) {
        return lineNameMap.get(lineId);
    }
}
