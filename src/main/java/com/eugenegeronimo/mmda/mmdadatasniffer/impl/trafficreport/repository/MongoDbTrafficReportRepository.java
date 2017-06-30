package com.eugenegeronimo.mmda.mmdadatasniffer.impl.trafficreport.repository;

import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.TrafficReport;
import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.repository.TrafficReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
@Profile("mongodb")
public class MongoDbTrafficReportRepository implements TrafficReportRepository {

    private final MongoOperations operations;

    @Autowired
    public MongoDbTrafficReportRepository(MongoOperations operations) {
        Assert.notNull(operations, "Argument operations is required.");
        this.operations = operations;
    }

    @Override
    public void save(TrafficReport trafficReport) {
        Assert.notNull(trafficReport, "Argument trafficReport is required.");
        operations.save(trafficReport);
    }
}
