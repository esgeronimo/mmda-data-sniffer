package com.eugenegeronimo.mmda.mmdadatasniffer.impl.trafficreport.client;

import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.Line;
import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.Route;
import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.TrafficPoint;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.json.JsonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.context.MessageSource;

import java.util.List;
import java.util.Locale;

public class LineListAdapterTest {

    @Test
    public void shouldReturnLineList() {
        String jsonResponse = "[[[1,1,\"0\",\"011\",\"0\",\"0\",\"0\"],[4,\"20170512183654\",\"114\",0,\"\"],[1,\"20170512183654\",\"114\",0,\"\"]],[[1,2,\"0\",\"111\",\"0\",\"0\",\"0\"],[3,\"20170512183654\",\"114\",0,\"\"],[3,\"20170512183654\",\"114\",0,\"\"]]]";

        TrafficPointMap trafficPointMap = new TrafficPointMap();

        LineMap lineMap = new LineMap();

        MessageSource messageSource = Mockito.mock(MessageSource.class);
        Mockito.when(messageSource.getMessage(Mockito.anyString(), Mockito.eq(null), Mockito.any(Locale.class))).thenReturn("South Bound");

        JsonParser jsonParser = new JsonJsonParser();

        LineListAdapter lineListAdapter = new LineListAdapter(trafficPointMap, lineMap, messageSource, jsonParser);

        List<Line> lineList = lineListAdapter.parse(jsonResponse);
        Assert.assertEquals(1, lineList.size());

        Line line = lineList.get(0);
        Assert.assertEquals("1", line.getId());
        Assert.assertEquals("EDSA", line.getName());
        Assert.assertEquals(2, line.getTrafficPoints().size());

        TrafficPoint trafficPoint = line.getTrafficPoints().get(1);
        Assert.assertEquals("2", trafficPoint.getId());
        Assert.assertEquals("1", trafficPoint.getLineId());
        Assert.assertEquals("EDSA", trafficPoint.getLineName());
        Assert.assertEquals("Kaingin Road", trafficPoint.getName());
        Assert.assertEquals(2, trafficPoint.getRoutes().size());

        Route route = trafficPoint.getRoutes().get(1);
        Assert.assertEquals("South Bound", route.getName());
        Assert.assertEquals(Long.valueOf(20170512183654L), route.getTimestamp());
        Assert.assertEquals(Integer.valueOf(3), route.getCongestionLevel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfInputIsNotJsonArray() {
        String jsonResponse = "{data: \"This sample data is incorrect\"}";

        TrafficPointMap trafficPointMap = new TrafficPointMap();

        LineMap lineMap = new LineMap();

        MessageSource messageSource = Mockito.mock(MessageSource.class);
        Mockito.when(messageSource.getMessage(Mockito.anyString(), Mockito.eq(null), Mockito.any(Locale.class))).thenReturn("South Bound");

        JsonParser jsonParser = new JsonJsonParser();

        LineListAdapter lineListAdapter = new LineListAdapter(trafficPointMap, lineMap, messageSource, jsonParser);
        lineListAdapter.parse(jsonResponse);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowEceptionIfInputHasIncorrectFormat() {
        throw new IllegalArgumentException();
    }
}
