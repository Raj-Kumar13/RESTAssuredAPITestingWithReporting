package com.demo.LocalAPITestData.TestData;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FormatterForTestData {
    public static JsonPath jsonPathConverter(Response response) {
        return new JsonPath(response.asString());
    }

}
