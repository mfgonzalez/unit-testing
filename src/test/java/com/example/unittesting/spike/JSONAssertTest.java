package com.example.unittesting.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JSONAssertTest {

    private String actualResponse = "{\"id\":1,\"name\":\"ball 2\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAsset_strictTrue_ExactMatchExceptForSpaces() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"ball 2\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }

    @Test
    public void jsonAsset_strictFalse() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"ball 2\"}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

    @Test
    public void jsonAsset_strictFalse_withoutEscapeCharacters() throws JSONException {
        String expectedResponse = "{id:1,name:\"ball 2\"}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

}
