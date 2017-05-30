package com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.repository;

import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.TrafficReport;
import org.springframework.data.repository.Repository;

public interface TrafficReportRepository extends Repository<TrafficReport, String> {
    public void save(TrafficReport trafficReport);
}
