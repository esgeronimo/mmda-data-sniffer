package com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport;

import org.springframework.util.Assert;

import java.util.List;

public class Line {
    private String id;
    private String name;
    private List<TrafficPoint> trafficPoints;

    public Line(String id, String name, List<TrafficPoint> trafficPoints) {
        Assert.notNull(id, "Id cannot be null");
        Assert.notNull(name, "Name cannot be null");
        Assert.notNull(trafficPoints, "Traffic Points cannot be null");
        Assert.isTrue(!trafficPoints.isEmpty(), "Traffic Points must have a minimum of 1 item");

        this.id = id;
        this.name = name;
        this.trafficPoints = trafficPoints;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
