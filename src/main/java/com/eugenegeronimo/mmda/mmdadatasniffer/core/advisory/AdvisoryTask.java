package com.eugenegeronimo.mmda.mmdadatasniffer.core.advisory;

import com.eugenegeronimo.mmda.mmdadatasniffer.core.base.BaseTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// TODO
public class AdvisoryTask implements BaseTask {

    private static final Logger log = LoggerFactory.getLogger(AdvisoryTask.class);

    private AdvisoryRepository repository;

    private AdvisoryApiClient apiClient;

    @Autowired
    public  AdvisoryTask(AdvisoryRepository repository, AdvisoryApiClient apiClient) {
        this.repository = repository;
        this.apiClient = apiClient;
    }

    @Override
    public void getAndSave() {

    }
}
