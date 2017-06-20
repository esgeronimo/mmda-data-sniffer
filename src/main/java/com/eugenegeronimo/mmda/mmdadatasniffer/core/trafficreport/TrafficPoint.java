package com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class TrafficPoint {
    private String trafficPointId;
    private String lineId;
    private String lineName;
    private String name;
    private List<Route> routes;
    private List<Advisory> advisories; // optional

    public TrafficPoint(String trafficPointId, String lineId, String lineName, String name, List<Route> routes, List<Advisory> advisories) {
        Assert.notNull(trafficPointId, "Traffic Point ID cannot be null");
        Assert.notNull(lineId, "Line ID cannot be null");
        Assert.notNull(lineName, "Line Name cannot be null");
        Assert.notNull(name, "Name cannot be null");
        Assert.notNull(routes, "Routes cannot be null");
        Assert.isTrue(!routes.isEmpty(), "Routes must have a minimum of 1 item");

        this.trafficPointId = trafficPointId;
        this.lineId = lineId;
        this.lineName = lineName;
        this.name = name;
        this.routes = routes;
        this.advisories =  advisories;
    }

    public String getTrafficPointId() {
        return trafficPointId;
    }

    public void setTrafficPointId(String trafficPointId) {
        this.trafficPointId = trafficPointId;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Route> getRoutes() {
        if (routes == null) {
            routes = new ArrayList<>();
        }
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public List<Advisory> getAdvisories() {
        return advisories;
    }

    public void setAdvisories(List<Advisory> advisories) {
        if (routes == null) {
            routes = new ArrayList<>();
        }
        this.advisories = advisories;
    }
}
