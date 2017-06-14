package com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport;

import org.springframework.data.annotation.Id;
import org.springframework.util.Assert;

import java.util.List;

public class TrafficReport {
    @Id
    private String id;
    private Long timestamp;
    private List<Line> lines;

    public TrafficReport(String id, Long timestamp, List<Line> lines) {
        Assert.notNull(id, "ID cannot be null");
        Assert.notNull(timestamp, "Timestamp cannot be null");
        Assert.notNull(lines, "Lines cannot be null");
        Assert.isTrue(!lines.isEmpty(), "Lines must have a minimum of 1 item");

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
