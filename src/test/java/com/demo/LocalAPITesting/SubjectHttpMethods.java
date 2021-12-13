package com.demo.LocalAPITesting;

import static com.demo.LocalAPITestData.TestData.FormatterForTestData.jsonPathConverter;
import static com.demo.LocalAPITestData.TestData.PayLoad.createTestDataForSubject;
import static com.demo.LocalAPITestData.TestData.PayLoad.updateTestDataForSubject;
import static io.restassured.RestAssured.given;

import org.junit.Assert;
import org.testng.annotations.Test;



import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SubjectHttpMethods extends BaseURL{

    @Test(priority =5,description = "Get Subject List using Get Method")
    public void getSubjectsList() {
        int id =1;
        String subjectName ="maths";
        Response response =given().header("Content-Type","Application.json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().get("subjects")
                .then().extract().response();
        JsonPath jsonPath = jsonPathConverter(response);
        addResponseToReport(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(jsonPath.getInt("id[0]"), id);
        Assert.assertEquals(jsonPath.getString("subjectName[0]"), subjectName);
    }

    @Test(priority =6,description = "Get subject details By ID using Get Mesthod")
    public void getSubjectsById() {
        int id =2;
        String subjectName = "english";
        Response response =given().header("Content-Type","Application.json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().get("subjects/{id}",id)
                .then().extract().response();
        JsonPath jsonPath = jsonPathConverter(response);
        addResponseToReport(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(jsonPath.getInt("id"),id );
        Assert.assertEquals(jsonPath.getString("subjectName"), subjectName);
    }

    @Test(priority =7,description = "Create subject details using Post Mesthod")
    public void createSubject() {

        String subjectName="Social";

        Response response =	given().header("Content-Type","Application.json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(createTestDataForSubject(subjectName)).
                when().post("subjects").
                then().extract().response();

        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertNotNull(response.body());
        JsonPath jsonPath = jsonPathConverter(response);
        addResponseToReport(response.asPrettyString());
        Assert.assertEquals(jsonPath.getString("subjectName"),subjectName);
    }
    @Test(priority =8,description = "Update subject details By ID using Put Mesthod")
    public void updateSubjectDetailsByID() {

        String subjectName="Economics";
        int id=3;

        Response response = given().header("Content-Type","Application.json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(updateTestDataForSubject(subjectName))
                .when().put("subjects/"+id)
                .then().extract().response();
        JsonPath jsonPath = jsonPathConverter(response);
        addResponseToReport(response.asPrettyString());
        Assert.assertEquals(jsonPath.getString("subjectName"),subjectName);

    }

    @Test(priority=9,description = "Delete subject details By ID using Delete Mesthod")
    public void deleteSubjectByID() {
        int id =8;

        Response response = given()
                .when().delete("subjects/"+id)
                .then().extract().response();
        Assert.assertEquals(response.getStatusCode(), 200);

    }

}

