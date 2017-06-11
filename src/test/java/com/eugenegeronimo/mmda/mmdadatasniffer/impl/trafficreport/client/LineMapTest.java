package com.eugenegeronimo.mmda.mmdadatasniffer.impl.trafficreport.client;

import org.junit.Assert;
import org.junit.Test;

public class LineMapTest {

    @Test
    public void shouldReturnLineMapValueOnValidInput() {
        LineMap lineMap = new LineMap();
        for (int i = 1; i <= 10; i++) {
            Assert.assertNotNull(lineMap.getLineName(String.valueOf(i)));
        }
    }

    @Test
    public void shouldReturnNullOnInvalidInput() {
        LineMap lineMap = new LineMap();
        Assert.assertNull(lineMap.getLineName("Some random value"));
    }
}
