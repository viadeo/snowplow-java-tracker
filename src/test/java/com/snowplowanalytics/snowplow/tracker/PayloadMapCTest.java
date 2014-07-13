package com.snowplowanalytics.snowplow.tracker;

import junit.framework.TestCase;

import org.junit.Test;

public class PayloadMapCTest extends TestCase {

    @Test
    public void testEmptyParamConstructor() throws Exception {
        PayloadMap payloadMap = new PayloadMapC();
        assertEquals(true, payloadMap.getParams().isEmpty());
    }

    @Test
    public void testEmptyConfigConstructor() throws Exception {
        PayloadMap payloadMap = new PayloadMapC();
        assertEquals(true, payloadMap.getConfigs().isEmpty());
    }

    @Test
    public void testSetParamMap() throws Exception {
        LinkedHashMap<String, String> param = new LinkedHashMap<String, String>();
        param.put("e","pv");
        PayloadMap payloadMap = new PayloadMapC(param,null);
        assertEquals(param, payloadMap.getParams());
        assertNull(payloadMap.getConfigs());
    }

    @Test
    public void testSetTransactionId() throws Exception {
        PayloadMapC payloadMap = new PayloadMapC();
        payloadMap.setTransactionID();
        Integer i = Integer.parseInt(payloadMap.getParam("tid"));
        // Just a formality, the parseLong would catch the error
        assertTrue(i instanceof Integer);
    }

    @Test
    public void testSetTimestamp() throws Exception {
        PayloadMapC payloadMap = new PayloadMapC();
        payloadMap.setTimestamp();
        Long i = Long.parseLong(payloadMap.getParam("dtm"));
        // Just a formality, the parseLong would catch the error
        assertTrue(i instanceof Long);
    }

    @Test
    public void testSetTimestamp2() throws Exception {
        PayloadMapC payloadMap = new PayloadMapC();
        payloadMap.setTimestamp(123456);
        assertEquals("123456.0", payloadMap.getParam("dtm"));
    }

    @Test
    public void testAdd() throws Exception {
        PayloadMapC payloadMap = new PayloadMapC();
        payloadMap.add("e", "pv");

    }

}