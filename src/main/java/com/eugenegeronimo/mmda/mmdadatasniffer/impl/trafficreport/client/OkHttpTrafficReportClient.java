package com.eugenegeronimo.mmda.mmdadatasniffer.impl.trafficreport.client;

import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.TrafficReport;
import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.client.TrafficReportApiClient;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class OkHttpTrafficReportClient implements TrafficReportApiClient {

    private static final Logger log = LoggerFactory.getLogger(OkHttpTrafficReportClient.class);

    private OkHttpClient client;

    private LineListAdapter adapter;

    private String url;

    @Autowired(required = true)
    public OkHttpTrafficReportClient(OkHttpClient client, LineListAdapter adapter, @Value("${api.url.trafficreport}") String url) {
        this.client = client;
        this.adapter = adapter;
        this.url = url;
    }

    @Override
    public TrafficReport getTrafficReport(Long timestamp) throws HttpException {
        // Add URL parameters
        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
        urlBuilder.addQueryParameter(QUERY_PARAMS_TIMESTAMP, String.valueOf(timestamp));

        // Build Request
        Request request = new Request.Builder()
                .url(urlBuilder.build().toString())
                .build();

        Response response;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return new TrafficReport(
                        UUID.randomUUID().toString(), //id
                        timestamp, //timestamp
                        adapter.parse(response.body().string()) //lines
                );
            }
            // Throw HttpException if response is not successful
            throw new HttpException(response.message(), response.code());
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
}
