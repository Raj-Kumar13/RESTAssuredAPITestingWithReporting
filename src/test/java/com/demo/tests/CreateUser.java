package com.demo.tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static com.demo.testdata.PayLoad.*;
import static com.demo.utills.Formatter.jsonPathConverter;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateUser extends BaseURL
{

    @Test(priority=2)
    public void createUserUsingPostMethod() {
        String name ="Mohan";
        String job ="Manager";

        Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(createUserDataForTesting(name,job))
                .when().post("/users")
                .then().extract().response();
        JsonPath jsonPath =	jsonPathConverter(response);
        Assert.assertEquals(response.statusCode(),201);
        Assert.assertEquals(jsonPath.getString("name"), name);
        Assert.assertEquals(jsonPath.getString("job"), job);
        Assert.assertNotNull(response.body());
    }


}

