package com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport;

public class Advisory {
    private String lineId;
    private String trafficPointId;
    private String message;

    public Advisory(String lineId, String trafficPointId, String message) {
        if (lineId == null) {
            throw new IllegalArgumentException("Line ID cannot be null");
        }
        if (trafficPointId == null) {
            throw new IllegalArgumentException("Traffic Point ID cannot be null");
        }
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }

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
