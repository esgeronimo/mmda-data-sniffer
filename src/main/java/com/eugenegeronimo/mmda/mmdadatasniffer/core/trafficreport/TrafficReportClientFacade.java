package com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport;

import com.eugenegeronimo.mmda.mmdadatasniffer.core.base.BaseApiClient;
import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.client.AdvisoriesClient;
import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.client.TrafficReportApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.*;

@Component
public class TrafficReportClientFacade {

    private AdvisoriesClient advisoriesClient;
    private TrafficReportApiClient trafficReportClient;

    @Autowired
    public TrafficReportClientFacade(TrafficReportApiClient trafficReportClient, AdvisoriesClient advisoriesClient) {
        Assert.notNull(trafficReportClient, "Argument trafficReportClient is required.");
        Assert.notNull(advisoriesClient, "Argument advisoriesClient is required.");

        this.trafficReportClient = trafficReportClient;
        this.advisoriesClient = advisoriesClient;
    }

    public TrafficReport getTrafficReport(Long timestamp) throws BaseApiClient.HttpException {
        Assert.notNull(timestamp, "Argument timestamp is required.");

        List<Advisory> advisories = advisoriesClient.getAdvisories(timestamp);

        Map<String, List<Advisory>> advisoryMap = new HashMap<>();
        advisories.forEach(advisory -> {
            String key = advisory.getLineId() + "_" + advisory.getTrafficPointId();
            if (advisoryMap.containsKey(key)) {
                advisoryMap.get(key).add(advisory);
            } else {
                List<Advisory> advisoryMapList = new ArrayList<>();
                advisoryMapList.add(advisory);
                advisoryMap.put(key, advisoryMapList);
            }
        });

        TrafficReport trafficReport = trafficReportClient.getTrafficReport(timestamp);
        trafficReport.getLines().forEach(line -> {
            line.getTrafficPoints().forEach(trafficPoint -> {
                String key = trafficPoint.getLineId() + "_" + trafficPoint.getTrafficPointId();
                trafficPoint.setAdvisories(advisoryMap.get(key));
            });
        });

        return trafficReport;
    }
}
