package com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class TrafficPointTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfIdIsNull() {
        List routes = Mockito.mock(List.class);
        Mockito.when(routes.isEmpty()).thenReturn(false);
        List advisories = Mockito.mock(List.class);

        new TrafficPoint(null, "Line ID", "Line Name", "Name", routes, advisories);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfLineIdIsNull() {
        List routes = Mockito.mock(List.class);
        Mockito.when(routes.isEmpty()).thenReturn(false);
        List advisories = Mockito.mock(List.class);

        new TrafficPoint("ID", null, "Line Name", "Name", routes, advisories);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfLineNameIsNull() {
        List routes = Mockito.mock(List.class);
        Mockito.when(routes.isEmpty()).thenReturn(false);
        List advisories = Mockito.mock(List.class);

        new TrafficPoint("ID", "Line ID", null, "Name", routes, advisories);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfNameIsNull() {
        List routes = Mockito.mock(List.class);
        Mockito.when(routes.isEmpty()).thenReturn(false);
        List advisories = Mockito.mock(List.class);

        new TrafficPoint("ID", "Line ID", "Line Name", null, routes, advisories);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfRouteIsNull() {
        List advisories = Mockito.mock(List.class);

        new TrafficPoint("ID", "Line ID", "Line Name", "Name", null, advisories);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfRouteIsEmpty() {
        List routes = Mockito.mock(List.class);
        Mockito.when(routes.isEmpty()).thenReturn(true);
        List advisories = Mockito.mock(List.class);

        new TrafficPoint("ID", "Line ID", "Line Name", "Name", routes, advisories);
    }

    @Test
    public void shouldAcceptEmptyAdvisories() {
        List routes = Mockito.mock(List.class);
        Mockito.when(routes.isEmpty()).thenReturn(false);

        TrafficPoint trafficPoint;
        try {
            trafficPoint = new TrafficPoint("ID", "Line ID", "Line Name", "Name", routes, null);
            Assert.assertNull(trafficPoint.getAdvisories());
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(e.getMessage(), false); // Fails test if an exception is encountered caused by null advisories
        }
    }

    @Test
    public void shouldReturnInitiatedValues() {
        List routes = Mockito.mock(List.class);
        Mockito.when(routes.isEmpty()).thenReturn(false);
        List advisories = Mockito.mock(List.class);

        TrafficPoint trafficPoint = new TrafficPoint("ID", "Line ID", "Line Name", "Name", routes, advisories);
        Assert.assertEquals("ID", trafficPoint.getTrafficPointId());
        Assert.assertEquals("Line ID", trafficPoint.getLineId());
        Assert.assertEquals("Line Name", trafficPoint.getLineName());
        Assert.assertEquals("Name", trafficPoint.getName());
        Assert.assertEquals(routes, trafficPoint.getRoutes());
        Assert.assertEquals(advisories, trafficPoint.getAdvisories());
    }
}
