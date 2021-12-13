package com.demo.ReportConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void configReport() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Report/index.html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("REQRES API's Testing");
        spark.config().setReportName("HTTP Methodes Testing");
        extent.attachReporter(spark);
    }


    public static void flushReport() {
        extent.flush();
    }

    public static void createTest(String testName, String testCategory) {
        test = extent.createTest(testName)
                .assignCategory(testCategory)
                .assignAuthor("Adam")
                .assignDevice("chrome 95");

    }
    
    public static void logResponse(String message) {
    	String formattedMessage = message.replace("\n", "<br>");
    	test.info("<pre> "+formattedMessage+" </pre>");
    }
}
