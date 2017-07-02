package com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnExpression("'${task.scheduled.enable}' == 'true'")
public class TrafficReportTaskScheduler {

    private TrafficReportTask trafficReportTask;

    @Autowired
    public TrafficReportTaskScheduler(TrafficReportTask trafficReportTask) {
        this.trafficReportTask = trafficReportTask;
    }

    @Scheduled(fixedDelayString = "${task.scheduled.delay}")
    public void execute() {
        trafficReportTask.getAndSave();
    }
}
