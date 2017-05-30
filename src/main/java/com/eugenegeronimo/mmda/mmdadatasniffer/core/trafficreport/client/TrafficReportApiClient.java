package com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.client;

import com.eugenegeronimo.mmda.mmdadatasniffer.core.base.BaseApiClient;
import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.TrafficReport;

public interface TrafficReportApiClient extends BaseApiClient {
    public TrafficReport getTrafficReport(Long timestamp) throws HttpException;
}
