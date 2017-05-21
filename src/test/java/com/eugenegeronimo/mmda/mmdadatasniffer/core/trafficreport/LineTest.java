package com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class LineTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfIdIsNull() {
        List trafficPoints = Mockito.mock(List.class);
        Mockito.when(trafficPoints.isEmpty()).thenReturn(false);

        new Line(null, "Name", trafficPoints);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfNameIsNull() {
        List trafficPoints = Mockito.mock(List.class);
        Mockito.when(trafficPoints.isEmpty()).thenReturn(false);

        new Line("ID", null, trafficPoints);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfTrafficPointsIsNull() {
        new Line("ID", "Name", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfTrafficPointsIsEmpty() {
        List trafficPoints = Mockito.mock(List.class);
        Mockito.when(trafficPoints.isEmpty()).thenReturn(true);

        new Line("ID", null, trafficPoints);
    }
}
