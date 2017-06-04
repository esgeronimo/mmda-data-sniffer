package com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport;

import org.springframework.data.annotation.Id;

import java.util.List;

public class TrafficReport {
    @Id
    private String id;
    private Long timestamp;
    private List<Line> lines;

    public TrafficReport(String id, Long timestamp, List<Line> lines) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        if (timestamp == null) {
            throw new IllegalArgumentException("Timestamp cannot be null");
        }
        if (lines == null) {
            throw new IllegalArgumentException("Lines cannot be null");
        }
        if (lines.isEmpty()) {
            throw new IllegalArgumentException("Lines must have a minimum of 1 item");
        }

        this.id = id;
        this.timestamp = timestamp;
        this.lines = lines;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        return "TrafficReport{" +
                "id='" + id + '\'' +
                ", timestamp=" + timestamp +
                ", lines=" + lines +
                '}';
    }
}
