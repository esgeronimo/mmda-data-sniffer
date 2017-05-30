package com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport;

public class Advisory {
    private String id;
    private String lineId;
    private String trafficPointId;
    private String routeName;
    private String message;

    public Advisory(String id, String lineId,
                    String trafficPointId, String routeName, String message) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        if (lineId == null) {
            throw new IllegalArgumentException("Line ID cannot be null");
        }
        if (trafficPointId == null) {
            throw new IllegalArgumentException("Traffic Point ID cannot be null");
        }
        if (routeName == null) {
            throw new IllegalArgumentException("Route Name cannot be null");
        }
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }

        this.id = id;
        this.lineId = lineId;
        this.trafficPointId = trafficPointId;
        this.routeName = routeName;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
