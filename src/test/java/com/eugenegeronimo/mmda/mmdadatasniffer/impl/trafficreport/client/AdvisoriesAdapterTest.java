package com.eugenegeronimo.mmda.mmdadatasniffer.impl.trafficreport.client;

import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.Advisory;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.json.JsonJsonParser;
import org.springframework.boot.json.JsonParser;

import java.util.List;

public class AdvisoriesAdapterTest {

    @Test
    public void shouldReturnAdvisoryList() {
        String jsonResponse = "[[1,30,{\"1\":[[\"20170510235800\",\"312\",\"ADVISORY: DPWH Expansion Joint Rehabilitation at EDSA Magallanes F\\/O SB. as of 11:58 PM. 1 lane occupied.\"],[\"20161002121200\",\"517\",\"ADVISORY: Ongoing Skyway Stage 3 works along Osmena Highway and Quirino Avenue.\"]]}],[2,51,[[[\"20160519105100\",\"5112\",\"ADVISORY: The intersection of Quezon Ave Roosevelt Ave is temporarily CLOSED until further notice to give way to the Skyway Stage 3 project.\"]],[[\"20160519105100\",\"5112\",\"ADVISORY: The intersection of Quezon Ave Roosevelt Ave is temporarily CLOSED until further notice to give way to the Skyway Stage 3 project.\"]]]],[4,72,[[[\"20170512131600\",\"215\",\"ADVISORY: Stalled mixer due to mechanical problem at C5 Libis F\\/O NB as of 1:16 PM. 1 lane occupied. MMDA on site.\"]]]],[4,79,{\"1\":[[\"20160930085300\",\"517\",\"ADVISORY: Ongoing DPWH Drainage Improvement at C5 Kalayaan 19 Ave. SB. 2 lanes occupied. Expect heavy traffic in the area. \"]]}],[4,80,{\"1\":[[\"20170328071500\",\"501\",\"ADVISORY: Ongoing DPWH Road Re-blocking at C5 Upper Mckinley SB as of 7:15 AM. 2 lanes occupied. Expect heavy traffic in the area.\"]]}],[9,110,{\"1\":[[\"20161002010000\",\"517\",\"ADVISORY: Ongoing LRT2 Ext. Project test pitting by contractor at Robinsons East EB WB. 1 lane occupied both direction. Expect MH traffic.\"]]}]]";
        JsonParser jsonParser = new JsonJsonParser();

        AdvisoriesAdapter adapter = new AdvisoriesAdapter(jsonParser);
        List<Advisory> advisories = adapter.parse(jsonResponse);
        Assert.assertEquals(8, advisories.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfInputIsNotJsonArray() {
        String jsonResponse = "{data: \"This sample data is incorrect\"}";
        JsonParser jsonParser = new JsonJsonParser();

        AdvisoriesAdapter adapter = new AdvisoriesAdapter(jsonParser);
        adapter.parse(jsonResponse);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfInputHasIncorrectFormat() {
        String jsonResponse = "[This, is not, even an array!]";
        JsonParser jsonParser = new JsonJsonParser();

        AdvisoriesAdapter adapter = new AdvisoriesAdapter(jsonParser);
        adapter.parse(jsonResponse);
    }
}
