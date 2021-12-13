package com.demo.tests;

import static io.restassured.RestAssured.baseURI;

import org.testng.annotations.BeforeTest;

import com.demo.ReportConfig.ReportManager;

public class BaseURL {


    @BeforeTest
    public void setUpBaseURL() {
        baseURI = "https://reqres.in/api";
    }

    public static void addResponseToReport(String response) {
    	ReportManager.logResponse(response);
    }
}

