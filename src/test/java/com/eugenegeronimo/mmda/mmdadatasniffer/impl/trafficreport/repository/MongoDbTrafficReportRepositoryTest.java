package com.eugenegeronimo.mmda.mmdadatasniffer.impl.trafficreport.repository;

import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.TrafficReport;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.data.mongodb.core.MongoOperations;

public class MongoDbTrafficReportRepositoryTest {

    @Test
    public void shouldSaveTrafficReport() {
        MongoOperations mongoOperations = Mockito.mock(MongoOperations.class);
        Mockito.doNothing().when(mongoOperations).save(Mockito.anyObject());

        TrafficReport trafficReport = Mockito.mock(TrafficReport.class);

        MongoDbTrafficReportRepository repository = new MongoDbTrafficReportRepository(mongoOperations);
        repository.save(trafficReport);

        Mockito.verify(mongoOperations, Mockito.times(1)).save(Mockito.anyObject());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfTrafficReportIsNull() {
        MongoOperations mongoOperations = Mockito.mock(MongoOperations.class);

        MongoDbTrafficReportRepository repository = new MongoDbTrafficReportRepository(mongoOperations);
        repository.save(null);
    }
}
