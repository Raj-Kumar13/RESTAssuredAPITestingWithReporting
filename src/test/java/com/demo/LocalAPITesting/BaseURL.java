package com.demo.LocalAPITesting;

import org.testng.annotations.BeforeTest;
import static io.restassured.RestAssured.baseURI;
public class BaseURL {

    @BeforeTest
    public void setUpBaseURL() {
        baseURI = "http://localhost:3000/";
    }
}
