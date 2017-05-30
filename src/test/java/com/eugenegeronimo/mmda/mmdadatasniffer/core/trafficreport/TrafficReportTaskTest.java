package com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport;

import com.eugenegeronimo.mmda.mmdadatasniffer.core.base.BaseApiClient;
import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.client.TrafficReportApiClient;
import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.repository.TrafficReportRepository;
import org.junit.Test;
import org.mockito.Mockito;

public class TrafficReportTaskTest {

    @Test
    public void shouldGetAndSave() throws BaseApiClient.HttpException {
        TrafficReportRepository repository = Mockito.mock(TrafficReportRepository.class);
        Mockito.doNothing().when(repository).save(Mockito.any(TrafficReport.class));

        TrafficReport trafficReport = Mockito.mock(TrafficReport.class);
        TrafficReportApiClient apiClient = Mockito.mock(TrafficReportApiClient.class);
        Mockito.when(apiClient.getTrafficReport(Mockito.anyLong())).thenReturn(trafficReport);

        new TrafficReportTask(repository, apiClient).getAndSave();

        Mockito.verify(apiClient, Mockito.times(1)).getTrafficReport(Mockito.anyLong());
        Mockito.verify(repository, Mockito.times(1)).save(trafficReport);
    }

    @Test
    public void shouldNotSaveTrafficReportWhenHttpExceptionThrown() throws BaseApiClient.HttpException {
        TrafficReportRepository repository = Mockito.mock(TrafficReportRepository.class);

        TrafficReportApiClient apiClient = Mockito.mock(TrafficReportApiClient.class);
        BaseApiClient.HttpException exception = Mockito.mock(BaseApiClient.HttpException.class);
        Mockito.when(apiClient.getTrafficReport(Mockito.anyLong())).thenThrow(exception);

        new TrafficReportTask(repository, apiClient).getAndSave();

        Mockito.verify(apiClient, Mockito.times(1)).getTrafficReport(Mockito.anyLong());
        Mockito.verify(repository, Mockito.never()).save(Mockito.any(TrafficReport.class));
    }
}
