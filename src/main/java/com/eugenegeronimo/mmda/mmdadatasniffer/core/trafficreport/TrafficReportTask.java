package com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport;


import com.eugenegeronimo.mmda.mmdadatasniffer.core.base.BaseApiClient;
import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.client.TrafficReportApiClient;
import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.repository.TrafficReportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TrafficReportTask {

    private static final Logger log = LoggerFactory.getLogger(TrafficReportTask.class);

    private TrafficReportRepository repository;
    private TrafficReportClientFacade trafficReportClient;

    @Autowired
    public TrafficReportTask(TrafficReportRepository repository, TrafficReportClientFacade traffocReportClient) {
        this.repository = repository;
        this.trafficReportClient = traffocReportClient;
    }

    public void getAndSave() {
        try {
            TrafficReport trafficReport = trafficReportClient.getTrafficReport(new Date().getTime());
            repository.save(trafficReport);
        } catch (BaseApiClient.HttpException e) {
            log.error(e.getMessage(), e);
        }
    }
}
