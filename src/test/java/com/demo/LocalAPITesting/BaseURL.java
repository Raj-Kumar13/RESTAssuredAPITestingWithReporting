package com.demo.LocalAPITesting;

import org.testng.annotations.BeforeTest;

import com.demo.ReportConfig.ReportManager;

import static io.restassured.RestAssured.baseURI;
public class BaseURL {

    @BeforeTest
    public void setUpBaseURL() {
        baseURI = "http://localhost:3000/";
    }
    public static void addResponseToReport(String response) {
    	ReportManager.logResponse(response);
    }
}
