package com.eugenegeronimo.mmda.mmdadatasniffer.impl.trafficreport.client;

import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.Advisory;
import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.client.AdvisoriesClient;
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
import java.util.List;

@Component
public class OkHttpAdvisoriesClient implements AdvisoriesClient {

    private static final Logger log = LoggerFactory.getLogger(OkHttpAdvisoriesClient.class);

    private OkHttpClient client;

    private AdvisoriesAdapter adapter;

    private String url;

    @Autowired(required = true)
    public OkHttpAdvisoriesClient(OkHttpClient client, AdvisoriesAdapter adapter, @Value("${api.url.advisories}") String url) {
        this.client = client;
        this.adapter = adapter;
        this.url = url;
    }

    @Override
    public List<Advisory> getAdvisories(Long timestamp) throws HttpException {
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
                return adapter.parse(response.body().string());
            }
            // Throw HttpException if response is not successful
            throw new HttpException(response.message(), response.code());
        } catch (IOException | IllegalArgumentException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
}
