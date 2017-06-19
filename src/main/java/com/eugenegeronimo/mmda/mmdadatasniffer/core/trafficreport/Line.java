package com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport;

import org.springframework.util.Assert;

import java.util.List;

public class Line {
    private String lineId;
    private String name;
    private List<TrafficPoint> trafficPoints;

    public Line(String lineId, String name, List<TrafficPoint> trafficPoints) {
        Assert.notNull(lineId, "Line ID cannot be null");
        Assert.notNull(name, "Name cannot be null");
        Assert.notNull(trafficPoints, "Traffic Points cannot be null");
        Assert.isTrue(!trafficPoints.isEmpty(), "Traffic Points must have a minimum of 1 item");

        this.lineId = lineId;
        this.name = name;
        this.trafficPoints = trafficPoints;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TrafficPoint> getTrafficPoints() {
        return trafficPoints;
    }

    public void setTrafficPoints(List<TrafficPoint> trafficPoints) {
        this.trafficPoints = trafficPoints;
    }
}
