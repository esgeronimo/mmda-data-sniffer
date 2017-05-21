package com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class TrafficPointTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfIdIsNull() {
        List routes = Mockito.mock(List.class);
        Mockito.when(routes.isEmpty()).thenReturn(false);

        new TrafficPoint(null, "Line ID", "Line Name", "Name", routes);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfLineIdIsNull() {
        List routes = Mockito.mock(List.class);
        Mockito.when(routes.isEmpty()).thenReturn(false);

        new TrafficPoint("ID", null, "Line Name", "Name", routes);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfLineNameIsNull() {
        List routes = Mockito.mock(List.class);
        Mockito.when(routes.isEmpty()).thenReturn(false);

        new TrafficPoint("ID", "Line ID", null, "Name", routes);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfNameIsNull() {
        List routes = Mockito.mock(List.class);
        Mockito.when(routes.isEmpty()).thenReturn(false);

        new TrafficPoint("ID", "Line ID", "Line Name", null, routes);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfRouteIsNull() {
        new TrafficPoint("ID", "Line ID", "Line Name", "Name", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfRouteIsEmpty() {
        List routes = Mockito.mock(List.class);
        Mockito.when(routes.isEmpty()).thenReturn(true);

        new TrafficPoint("ID", "Line ID", "Line Name", "Name", routes);
    }
}
