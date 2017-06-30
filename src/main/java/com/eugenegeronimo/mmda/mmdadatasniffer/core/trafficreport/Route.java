package com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport;

import org.springframework.util.Assert;

public class Route {
    private String name;
    private Long timestamp;
    private Integer congestionLevel;

    public Route(String name, Integer congestionLevel, Long timestamp) {
        Assert.notNull(name, "Argument name is required.");
        Assert.notNull(congestionLevel, "Argument congestionLevel is required.");
        Assert.notNull(timestamp, "Argument timestamp is required.");

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
