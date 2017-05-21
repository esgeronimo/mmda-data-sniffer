package com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport;

import org.springframework.data.repository.Repository;

public interface TrafficReportRepository extends Repository<TrafficReport, String> {
    public void save(TrafficReport trafficReport);
}
