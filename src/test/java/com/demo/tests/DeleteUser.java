package com.demo.tests;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DeleteUser  extends BaseURL{

    @Test(priority=5)
    public void deleteUserById() {

        Response response = given()
                .when().delete("users/1")
                .then().extract().response();

        Assert.assertEquals(response.statusCode(), 204);

    }

}