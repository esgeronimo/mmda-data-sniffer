package com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport;

import org.springframework.util.Assert;

public class Advisory {
    private String lineId;
    private String trafficPointId;
    private String message;

    public Advisory(String lineId, String trafficPointId, String message) {
        Assert.notNull(lineId, "Line ID cannot be null");
        Assert.notNull(trafficPointId, "Traffic Point ID cannot be null");
        Assert.notNull(message, "Message cannot be null");

        this.lineId = lineId;
        this.trafficPointId = trafficPointId;
        this.message = message;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getTrafficPointId() {
        return trafficPointId;
    }

    public void setTrafficPointId(String trafficPointId) {
        this.trafficPointId = trafficPointId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
