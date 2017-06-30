package com.eugenegeronimo.mmda.mmdadatasniffer.impl.trafficreport.client;

import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.Advisory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class AdvisoriesAdapter extends BaseAdapter {

    private static final int INDEX_ADVISORY_DETAILS_LINE_ID = 0;
    private static final int INDEX_ADVISORY_DETAILS_TRAFFIC_POINT_ID = 1;
    private static final int INDEX_ADVISORY_DETAILS_MESSAGES = 2;

    private static final int INDEX_MESSAGE_PROPERTY_MESSAGE = 2;

    private JsonParser jsonParser;

    @Autowired
    public AdvisoriesAdapter(JsonParser jsonParser) {
        this.jsonParser = jsonParser;
    }

    public List<Advisory> parse(String json) {
        Assert.isTrue(!StringUtils.isEmpty(json), "Argument json should not be empty.");
        Assert.isTrue(isJsonArray(json), "Input should be a JSON array: " + json);

        List<Advisory> advisories = new ArrayList<>();
        jsonParser.parseList(json).forEach(jsonObject -> {
            advisories.addAll(getAdvisoriesPerTrafficPoint(jsonObject));
        });

        return advisories;
    }

    private List<Advisory> getAdvisoriesPerTrafficPoint(Object jsonObject) {
        Assert.isInstanceOf(List.class, jsonObject, "Should be a list: " + jsonObject.toString());

        List<Advisory> advisories = new ArrayList<>();

        if (jsonObject instanceof List) {
            List<Object> advisoryProperties = (List<Object>) jsonObject;
            String lineId = String.valueOf(advisoryProperties.get(INDEX_ADVISORY_DETAILS_LINE_ID));
            String trafficPointId = String.valueOf(advisoryProperties.get(INDEX_ADVISORY_DETAILS_TRAFFIC_POINT_ID));

            getMessages(advisoryProperties.get(INDEX_ADVISORY_DETAILS_MESSAGES)).forEach(message -> {
                advisories.add(new Advisory(lineId, trafficPointId, message));
            });
        }

        return advisories;
    }

    private List<String> getMessages(Object jsonObject) {
        Assert.isTrue((jsonObject instanceof List) || (jsonObject instanceof Map), "Should be a list or map: " + jsonObject.toString());

        List<String> messages = new ArrayList<>();

        if (jsonObject instanceof List) {
            ((List)jsonObject).forEach(route -> {

                Assert.isInstanceOf(List.class, route, "Should be a list: " + route.toString());
                ((List) route).forEach(message -> {

                    Assert.isInstanceOf(List.class, message, "Should be a list: " + message.toString());
                    List<Object> messageProperties = (List<Object>) message;
                    messages.add(String.valueOf(messageProperties.get(INDEX_MESSAGE_PROPERTY_MESSAGE)));
                });

            });
        } else {
            ((Map)jsonObject).forEach((key, value) -> {

                Assert.isInstanceOf(List.class, value, "Should be a list:" + value.toString());
                ((List) value).forEach(message -> {

                    Assert.isInstanceOf(List.class, message, "Should be a list: " + message.toString());
                    List<Object> messageProperties = (List<Object>) message;
                    messages.add(String.valueOf(messageProperties.get(INDEX_MESSAGE_PROPERTY_MESSAGE)));
                });
            });
        }

        return messages;
    }
}
