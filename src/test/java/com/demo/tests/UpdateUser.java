package com.demo.tests;

import static com.demo.testdata.PayLoad.updateUserDataForTesting;
import static com.demo.utills.Formatter.jsonPathConverter;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class UpdateUser extends BaseURL{

    @Test(priority=3)
    public void updateUserDetailsByIdUsingPutMethod() {
        String name = "ravi";
        String job = "Tester";

        Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(updateUserDataForTesting(name,job))
                .when().put("/users/2")
                .then().extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        JsonPath jsonPath =jsonPathConverter(response);
        Assert.assertNotNull(response.body());
        Assert.assertEquals(jsonPath.getString("job"), job);
        Assert.assertEquals(jsonPath.getString("name"), name);
    }




    @Test(priority=4)
    public void updateUserDetailsByIdUsingPatchMethod() {
        String name = "eon";
        String job = "Morgan";

        Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(updateUserDataForTesting(name,job))
                .when().put("/users/4")
                .then().extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        JsonPath jsonPath =jsonPathConverter(response);
        Assert.assertEquals(jsonPath.getString("name"), name);
        Assert.assertEquals(jsonPath.getString("job"), job);
        Assert.assertNotNull(response.body());
    }

}

