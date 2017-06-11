package com.eugenegeronimo.mmda.mmdadatasniffer.impl.trafficreport.client;

import org.junit.Assert;
import org.junit.Test;

public class TrafficPointMapTest {

    @Test
    public void shouldReturnLineMapValueOnValidInput() {
        TrafficPointMap trafficPointMap = new TrafficPointMap();

        String lineId = "1";
        for (int i = 1; i <= 37; i++) {
            Assert.assertNotNull(trafficPointMap.getTrafficPointName(lineId, String.valueOf(i)));
        }

        lineId = "7";
        for (int i = 98; i <= 108; i++) {
            Assert.assertNotNull(trafficPointMap.getTrafficPointName(lineId, String.valueOf(i)));
        }

        Assert.assertNotNull(trafficPointMap.getTrafficPointName(lineId, "38"));

        lineId = "2";
        for (int i = 39; i <= 63; i++) {
            Assert.assertNotNull(trafficPointMap.getTrafficPointName(lineId, String.valueOf(i)));
        }

        lineId = "3";
        for (int i = 64; i <= 71; i++) {
            Assert.assertNotNull(trafficPointMap.getTrafficPointName(lineId, String.valueOf(i)));
        }

        lineId = "4";
        for (int i = 131; i <= 140; i++) {
            Assert.assertNotNull(trafficPointMap.getTrafficPointName(lineId, String.valueOf(i)));
        }

        lineId = "4";
        for (int i = 72; i <= 80; i++) {
            Assert.assertNotNull(trafficPointMap.getTrafficPointName(lineId, String.valueOf(i)));
        }

        lineId = "8";
        for (int i = 116; i <= 130; i++) {
            Assert.assertNotNull(trafficPointMap.getTrafficPointName(lineId, String.valueOf(i)));
        }

        lineId = "9";
        for (int i = 109; i <= 115; i++) {
            Assert.assertNotNull(trafficPointMap.getTrafficPointName(lineId, String.valueOf(i)));
        }

        lineId = "5";
        for (int i = 81; i <= 91; i++) {
            Assert.assertNotNull(trafficPointMap.getTrafficPointName(lineId, String.valueOf(i)));
        }

        Assert.assertNotNull(trafficPointMap.getTrafficPointName(lineId, "142"));

        lineId = "6";
        for (int i = 92; i <= 97; i++) {
            Assert.assertNotNull(trafficPointMap.getTrafficPointName(lineId, String.valueOf(i)));
        }

        Assert.assertNotNull(trafficPointMap.getTrafficPointName(lineId, "141"));

        lineId = "10";
        for (int i = 159; i <= 171; i++) {
            Assert.assertNotNull(trafficPointMap.getTrafficPointName(lineId, String.valueOf(i)));
        }

        Assert.assertNotNull(trafficPointMap.getTrafficPointName(lineId, "157"));

    }

    @Test
    public void shouldReturnNullOnInvalidInput() {
        TrafficPointMap trafficPointMap = new TrafficPointMap();
        Assert.assertNull(trafficPointMap.getTrafficPointName("Line ID", "Traffic Point ID"));
        Assert.assertNull(trafficPointMap.getTrafficPointName(null, "169"));
        Assert.assertNull(trafficPointMap.getTrafficPointName("1", null));
    }
}
