package com.demo.utills;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Formatter {

    public static JsonPath jsonPathConverter(Response response) {
        return new JsonPath(response.asString());
    }
}
