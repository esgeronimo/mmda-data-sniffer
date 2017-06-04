package com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport;

import org.junit.Assert;
import org.junit.Test;

public class AdvisoryTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfLineIdIsNull() {
        new Advisory(null, "TrafficPointId", "Message");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfTrafficPointIdIsNull() {
        new Advisory("LineId", null, "Message");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionifMessageIsNull() {
        new Advisory("LineId", "TrafficPointId", null);
    }

    @Test
    public void shouldReturnInitiatedValues() {
        Advisory advisory = new Advisory("LineId", "TrafficPointId", "Message");
        Assert.assertEquals("LineId", advisory.getLineId());
        Assert.assertEquals("TrafficPointId", advisory.getTrafficPointId());
        Assert.assertEquals("Message", advisory.getMessage());
    }
}
