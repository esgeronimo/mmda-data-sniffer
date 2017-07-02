package com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.util.Assert;

import java.util.List;

@TypeAlias("TrafficReport")
public class TrafficReport {
    @Id
    private String id;
    private Long timestamp;
    private List<Line> lines;

    public TrafficReport(String id, Long timestamp, List<Line> lines) {
        Assert.notNull(id, "Argument id is required.");
        Assert.notNull(timestamp, "Argument timestamp is required.");
        Assert.notNull(lines, "Argument lines is required.");
        Assert.isTrue(!lines.isEmpty(), "Argument lines must have a minimum of 1 item.");

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
