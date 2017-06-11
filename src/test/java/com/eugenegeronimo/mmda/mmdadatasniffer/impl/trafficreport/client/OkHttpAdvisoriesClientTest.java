package com.eugenegeronimo.mmda.mmdadatasniffer.impl.trafficreport.client;

import com.eugenegeronimo.mmda.mmdadatasniffer.core.base.BaseApiClient;
import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.Advisory;
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
import java.util.List;

public class OkHttpAdvisoriesClientTest {

    private MockWebServer server;

    @Test
    public void shouldGetAdvisories() throws IOException, BaseApiClient.HttpException {
        String responseJson = "[[1,30,{\"1\":[[\"20170510235800\",\"312\",\"ADVISORY: DPWH Expansion Joint Rehabilitation at EDSA Magallanes F/O SB. as of 11:58 PM. 1 lane occupied.\"],[\"20161002121200\",\"517\",\"ADVISORY: Ongoing Skyway Stage 3 works along Osmena Highway and Quirino Avenue.\"]]}]]";
        server = new MockWebServer();
        server.enqueue(new MockResponse().setBody(responseJson));
        server.start();

        // Initialise client
        OkHttpClient client = new OkHttpClient();

        // Initialise adapter
        AdvisoriesAdapter adapter = Mockito.mock(AdvisoriesAdapter.class);

        // Initialise url
        String url = String.format("http://%s:%d/advisories", server.getHostName(), server.getPort());

        // Instantiate API client
        OkHttpAdvisoriesClient advisoriesClient = new OkHttpAdvisoriesClient(client, adapter, url);

        Advisory advisory = Mockito.mock(Advisory.class);
        Mockito.when(adapter.parse(responseJson)).thenReturn(Arrays.asList(advisory));

        Long timestamp = new Date().getTime();
        List<Advisory> advisories = advisoriesClient.getAdvisories(timestamp);

        Mockito.verify(adapter, Mockito.times(1)).parse(Mockito.anyString());
        Assert.assertEquals(1, advisories.size());
        Assert.assertEquals(advisory, advisories.get(0));

        server.shutdown();
    }

    @Test(expected = BaseApiClient.HttpException.class)
    public void shouldThrowHttpExceptionWhenServerReturnsUnsuccessfulResponse() throws IOException, BaseApiClient.HttpException {
        server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(500)); // Returns internal server error
        server.start();

        // Initialise client
        OkHttpClient client = new OkHttpClient();

        // Initialise adapter
        AdvisoriesAdapter adapter = Mockito.mock(AdvisoriesAdapter.class);

        // Initialise url
        String url = String.format("http://%s:%d/advisories", server.getHostName(), server.getPort());

        // Instantiate API client
        OkHttpAdvisoriesClient advisoriesClient = new OkHttpAdvisoriesClient(client, adapter, url);

        try {
            advisoriesClient.getAdvisories(1L);
        } catch (BaseApiClient.HttpException e) {
            // No conversion should be triggered if API call returns unsuccessful response
            Mockito.verify(adapter, Mockito.never()).parse(Mockito.anyString());

            Assert.assertEquals(500, e.getStatusCode());
            throw e;
        } finally {
            server.shutdown();
        }
    }

    @Test
    public void shouldReturnNullWhenServerConnectionReturnsException() throws IOException, BaseApiClient.HttpException {
        server = new MockWebServer();
        server.start();

        // Initialise client simulating an IOException during server call
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(chain -> {
            throw new IOException();
        }).build();

        // Initialise adapter
        AdvisoriesAdapter adapter = Mockito.mock(AdvisoriesAdapter.class);

        // Initialise url
        String url = String.format("http://%s:%d/advisories", server.getHostName(), server.getPort());

        // Instantiate API client
        OkHttpAdvisoriesClient advisoriesClient = new OkHttpAdvisoriesClient(client, adapter, url);

        List<Advisory> advisories = advisoriesClient.getAdvisories(1L);

        Mockito.verify(adapter, Mockito.times(0)).parse(Mockito.anyString());
        Assert.assertNull(advisories);

        server.shutdown();
    }

    @Test
    public void shouldReturnNullWhenAdapterReturnsParsingError() throws IOException, BaseApiClient.HttpException {
        String responseJson = "[[1,30,{\"1\":[[\"20170510235800\",\"312\",\"ADVISORY: DPWH Expansion Joint Rehabilitation at EDSA Magallanes F/O SB. as of 11:58 PM. 1 lane occupied.\"],[\"20161002121200\",\"517\",\"ADVISORY: Ongoing Skyway Stage 3 works along Osmena Highway and Quirino Avenue.\"]]}]]";
        server = new MockWebServer();
        server.enqueue(new MockResponse().setBody(responseJson));
        server.start();

        // Initialise client
        OkHttpClient client = new OkHttpClient();

        // Initialise adapter
        AdvisoriesAdapter adapter = Mockito.mock(AdvisoriesAdapter.class);
        Mockito.doThrow(IllegalArgumentException.class).when(adapter).parse(Mockito.anyString());

        // Initialise url
        String url = String.format("http://%s:%d/advisories", server.getHostName(), server.getPort());

        // Instantiate API client
        OkHttpAdvisoriesClient advisoriesClient = new OkHttpAdvisoriesClient(client, adapter, url);

        List<Advisory> advisories = advisoriesClient.getAdvisories(1L);

        Mockito.verify(adapter, Mockito.times(1)).parse(Mockito.anyString());
        Assert.assertNull(advisories);

        server.shutdown();
    }

    @After
    public void tearDown() throws IOException {
        // Making sure mock server instance shuts down
        if (server != null) {
            server.shutdown();
        }
    }
}
