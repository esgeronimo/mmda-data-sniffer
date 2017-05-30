package com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport;

import java.util.ArrayList;
import java.util.List;

public class TrafficPoint {
    private String id;
    private String lineId;
    private String lineName;
    private String name;
    private List<Route> routes;
    private List<Advisory> advisories; // optional

    public TrafficPoint(String id, String lineId, String lineName, String name, List<Route> routes, List<Advisory> advisories) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        if (lineId == null) {
            throw new IllegalArgumentException("Line ID cannot be null");
        }
        if (lineName == null) {
            throw new IllegalArgumentException("Line Name cannot be null");
        }
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (routes == null) {
            throw new IllegalArgumentException("Routes cannot be null");
        }
        if (routes.isEmpty()) {
            throw new IllegalArgumentException("Routes must have a minimum of 1 item");
        }

        this.id = id;
        this.lineId = lineId;
        this.lineName = lineName;
        this.name = name;
        this.routes = routes;
        this.advisories =  advisories;
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
