package com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.client;

import com.eugenegeronimo.mmda.mmdadatasniffer.core.base.BaseApiClient;
import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.Advisory;

import java.util.List;

public interface AdvisoriesClient extends BaseApiClient {
    public List<Advisory> getAdvisories(Long timestamp) throws HttpException;
}
