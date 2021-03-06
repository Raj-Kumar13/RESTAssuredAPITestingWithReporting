package com.demo.tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.ReportConfig.ReportManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetUsers extends BaseURL {

    @Test(priority=0, description = "Get List User's Useing Get method")
    public void getAllUsers() {
        int pageNumber =1;

        Response response =  given().accept(ContentType.JSON).queryParam("page",pageNumber)
                .when().get("users")
                .then().extract().response();
        addResponseToReport(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("page"), 1);
        Assert.assertEquals(response.jsonPath().getInt("per_page"), 6);
        Assert.assertEquals(response.jsonPath().getInt("total"), 12);
        Assert.assertEquals(response.jsonPath().getInt("total_pages"),2);
        Assert.assertTrue(response.jsonPath().getString("data.email").contains("@reqres.in"));
        Assert.assertTrue(response.jsonPath().getString("support.url").contains("reqres.in") );
    }

    @Test(priority=1,description = "Get User Using Get method")
    public void getUserByID() {
        int id =1;
        Response response = given().accept(ContentType.JSON)
                .when().get("users/"+id)
                .then().extract().response();

        Assert.assertEquals(response.statusCode(),200);
        addResponseToReport(response.asPrettyString());
        Assert.assertEquals(response.jsonPath().getInt("data.id"),1);
        Assert.assertEquals(response.jsonPath().getString("data.email"),"george.bluth@reqres.in");
        Assert.assertEquals(response.jsonPath().getString("data.first_name"), "George");
        Assert.assertEquals(response.jsonPath().getString("data.last_name"), "Bluth");
        Assert.assertEquals(response.jsonPath().getString("data.avatar"), "https://reqres.in/img/faces/1-image.jpg");
    }
}

