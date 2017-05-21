package com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class TrafficReportTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfIdIsNull() {
        List lines = Mockito.mock(List.class);
        Mockito.when(lines.isEmpty()).thenReturn(false);

        new TrafficReport(null, 1L, lines);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfTimestampIsNull() {
        List lines = Mockito.mock(List.class);
        Mockito.when(lines.isEmpty()).thenReturn(false);

        new TrafficReport("ID", null, lines);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfLinesIsNull() {
        new TrafficReport("ID", 1L, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfLinesIsEmtpy() {
        List lines = Mockito.mock(List.class);
        Mockito.when(lines.isEmpty()).thenReturn(true);

        new TrafficReport("ID", 1L, lines);
    }
}
