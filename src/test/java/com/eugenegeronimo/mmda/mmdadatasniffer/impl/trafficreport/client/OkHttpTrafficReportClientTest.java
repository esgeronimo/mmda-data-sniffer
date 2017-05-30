package com.eugenegeronimo.mmda.mmdadatasniffer.impl.trafficreport.client;

import com.eugenegeronimo.mmda.mmdadatasniffer.core.base.BaseApiClient;
import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.Line;
import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.TrafficReport;
import com.eugenegeronimo.mmda.mmdadatasniffer.impl.trafficreport.client.OkHttpTrafficReportClient;
import com.eugenegeronimo.mmda.mmdadatasniffer.impl.trafficreport.client.LineListAdapter;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import okhttp3.OkHttpClient;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class OkHttpTrafficReportClientTest {

    private MockWebServer server;

    @Test
    public void shouldGetTrafficReport() throws IOException, BaseApiClient.HttpException {
        String responseJson = "{json: \"sample\"}";
        server = new MockWebServer();
        server.enqueue(new MockResponse().setBody(responseJson));
        server.start();

        // Initialise client
        OkHttpClient client = new OkHttpClient();

        // Initialise converter
        LineListAdapter converter = Mockito.mock(LineListAdapter.class);

        // Initialise url
        String url = String.format("http://%s:%d/trafficReport", server.getHostName(), server.getPort());

        // Instantiate API client
        OkHttpTrafficReportClient trafficReportApiClient = new OkHttpTrafficReportClient(client, converter, url);

        Line line = Mockito.mock(Line.class);
        Mockito.when(converter.parse(responseJson)).thenReturn(Arrays.asList(line));

        Long timestamp = new Date().getTime();
        TrafficReport trafficReport = trafficReportApiClient.getTrafficReport(timestamp);

        Assert.assertFalse(trafficReport.getLines().isEmpty());
        Assert.assertEquals(1, trafficReport.getLines().size());
        Assert.assertEquals(timestamp, trafficReport.getTimestamp());

        server.shutdown();
    }

    @Test(expected = BaseApiClient.HttpException.class)
    public void shouldThrowHttpExceptionWhenServerReturnsUnsuccessfulResponse() throws IOException, BaseApiClient.HttpException {
        server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(500)); // Returns internal server error
        server.start();

        // Initialise client
        OkHttpClient client = new OkHttpClient();

        // Initialise converter
        LineListAdapter converter = Mockito.mock(LineListAdapter.class);

        // Initialise url
        String url = String.format("http://%s:%d/trafficReport", server.getHostName(), server.getPort());

        // Instantiate API client
        OkHttpTrafficReportClient trafficReportApiClient = new OkHttpTrafficReportClient(client, converter, url);

        try {
            trafficReportApiClient.getTrafficReport(1L);
        } catch (BaseApiClient.HttpException e) {
            // No conversion should be triggered if API call returns unsuccessful response
            Mockito.verify(converter, Mockito.never()).parse(Mockito.anyString());

            Assert.assertEquals(500, e.getStatusCode());
            throw e;
        }
    }

    @After
    public void tearDown() throws IOException {
        // Making sure mock server instance shuts down
        if (server != null) {
            server.shutdown();
        }
    }
}
