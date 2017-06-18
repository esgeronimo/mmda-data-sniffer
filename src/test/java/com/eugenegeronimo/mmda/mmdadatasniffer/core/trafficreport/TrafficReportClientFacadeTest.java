package com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport;

import com.eugenegeronimo.mmda.mmdadatasniffer.core.base.BaseApiClient;
import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.client.AdvisoriesClient;
import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.client.TrafficReportApiClient;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TrafficReportClientFacadeTest {

    @Test
    public void shouldReturnTrafficReport() throws BaseApiClient.HttpException {

        String lineId = "LineId";
        String trafficPointId = "TrafficPointId";

        List<Advisory> advisories = generateAdvisories(lineId, trafficPointId);
        AdvisoriesClient advisoriesClient = Mockito.mock(AdvisoriesClient.class);
        Mockito.when(advisoriesClient.getAdvisories(Mockito.anyLong())).thenReturn(advisories);

        TrafficReport trafficReport = generateTrafficReport(lineId, trafficPointId);
        TrafficReportApiClient trafficReportClient = Mockito.mock(TrafficReportApiClient.class);
        Mockito.when(trafficReportClient.getTrafficReport(Mockito.anyLong())).thenReturn(trafficReport);

        TrafficReportClientFacade facade = new TrafficReportClientFacade(trafficReportClient, advisoriesClient);
        TrafficReport retrievedTrafficReport = facade.getTrafficReport(new Date().getTime());

        Assert.assertEquals(trafficReport, retrievedTrafficReport);
        Assert.assertEquals(advisories.get(0), retrievedTrafficReport.getLines().get(0).getTrafficPoints().get(0).getAdvisories().get(0));
    }

    @Test
    public void shouldReturnTrafficReportWithoutAdvisoriesIfLineIdDoesNotHaveAMatch() throws BaseApiClient.HttpException {
        String trafficPointId = "TrafficPointId";

        List<Advisory> advisories = generateAdvisories("DifferentLineId", trafficPointId);
        AdvisoriesClient advisoriesClient = Mockito.mock(AdvisoriesClient.class);
        Mockito.when(advisoriesClient.getAdvisories(Mockito.anyLong())).thenReturn(advisories);

        TrafficReport trafficReport = generateTrafficReport("LineId", trafficPointId);
        TrafficReportApiClient trafficReportClient = Mockito.mock(TrafficReportApiClient.class);
        Mockito.when(trafficReportClient.getTrafficReport(Mockito.anyLong())).thenReturn(trafficReport);

        TrafficReportClientFacade facade = new TrafficReportClientFacade(trafficReportClient, advisoriesClient);
        TrafficReport retrievedTrafficReport = facade.getTrafficReport(new Date().getTime());

        Assert.assertEquals(trafficReport, retrievedTrafficReport);
        Assert.assertNull(retrievedTrafficReport.getLines().get(0).getTrafficPoints().get(0).getAdvisories());
    }

    @Test
    public void shouldReturnTrafficReportWithoutAdvisoriesIfTrafficPointIdDoesNotHaveAMatch() throws BaseApiClient.HttpException {
        String lineId = "LineId";

        List<Advisory> advisories = generateAdvisories(lineId, "DifferentTrafficPointId");
        AdvisoriesClient advisoriesClient = Mockito.mock(AdvisoriesClient.class);
        Mockito.when(advisoriesClient.getAdvisories(Mockito.anyLong())).thenReturn(advisories);

        TrafficReport trafficReport = generateTrafficReport(lineId, "TrafficPointId");
        TrafficReportApiClient trafficReportClient = Mockito.mock(TrafficReportApiClient.class);
        Mockito.when(trafficReportClient.getTrafficReport(Mockito.anyLong())).thenReturn(trafficReport);

        TrafficReportClientFacade facade = new TrafficReportClientFacade(trafficReportClient, advisoriesClient);
        TrafficReport retrievedTrafficReport = facade.getTrafficReport(new Date().getTime());

        Assert.assertEquals(trafficReport, retrievedTrafficReport);
        Assert.assertNull(retrievedTrafficReport.getLines().get(0).getTrafficPoints().get(0).getAdvisories());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExceptionOnNullTimestamp() throws BaseApiClient.HttpException {
        TrafficReportApiClient trafficReportClient = Mockito.mock(TrafficReportApiClient.class);
        AdvisoriesClient advisoriesClient = Mockito.mock(AdvisoriesClient.class);
        new TrafficReportClientFacade(trafficReportClient, advisoriesClient).getTrafficReport(null);
    }

    private List<Advisory> generateAdvisories(String lineId, String trafficPointId) {
        Advisory advisory = new Advisory(lineId, trafficPointId, "Message");
        return Arrays.asList(advisory);
    }

    private TrafficReport generateTrafficReport(String lineId, String trafficPointId) {

        Long timestamp = new Date().getTime();

        Route route = new Route(
                "RouteName",
                1,
                timestamp
        );
        List<Route> routes = Arrays.asList(route);

        TrafficPoint trafficPoint = new TrafficPoint(
                trafficPointId,
                lineId,
                "LineName",
                "TrafficPointName",
                routes,
                null // Retrieved traffic points initially don't have advisories in it
        );
        List<TrafficPoint> trafficPoints = Arrays.asList(trafficPoint);

        Line line = new Line(
                lineId,
                "LineName",
                trafficPoints
        );
        List<Line> lines = Arrays.asList(line);

        TrafficReport trafficReport = new TrafficReport(
                UUID.randomUUID().toString(),
                timestamp,
                lines
        );

        return trafficReport;
    }
}
