package com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport;

public class Route {
    private String name;
    private Long timestamp;
    private Integer congestionLevel;

    public Route(String name, Integer congestionLevel, Long timestamp) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (congestionLevel == null) {
            throw new IllegalArgumentException("Congestion Level cannot be null");
        }
        if (timestamp == null) {
            throw new IllegalArgumentException("Timestamp cannot be null");
        }
        this.name = name;
        this.congestionLevel = congestionLevel;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCongestionLevel() {
        return congestionLevel;
    }

    public void setCongestionLevel(Integer congestionLevel) {
        this.congestionLevel = congestionLevel;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
