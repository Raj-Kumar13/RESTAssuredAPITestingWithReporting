package com.demo.LocalAPITesting;

import static com.demo.LocalAPITestData.TestData.FormatterForTestData.jsonPathConverter;
import static com.demo.LocalAPITestData.TestData.PayLoad.createTestDataForStudent;
import static com.demo.LocalAPITestData.TestData.PayLoad.updateTestDataForStudent;
import static io.restassured.RestAssured.given;

import org.junit.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class StudentHttpMethods extends BaseURL{

    @Test(priority =0,description = "Get Student List using Get Method")
    public void getStudentList() {

        Response response = given().header("Content-Type","Application.json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().get("student")
                .then().extract().response();
        addResponseToReport(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("id[0]"), 1);
        Assert.assertEquals(response.jsonPath().getString("Name[0]"), "Morgan");
        Assert.assertEquals(response.jsonPath().getInt("subjectId[0]"), 1);
        Assert.assertEquals(response.jsonPath().getInt("marks[0]"), 78);
        //	Assert.assertEquals(response.jsonPath().getList("data").size(),5);

    }

    @Test(priority =1,description = "Get Student details By ID using Get Mesthod")
    public void getStudentByID() {
        int id=2;

        Response response = given().accept(ContentType.JSON).queryParam("id", id)
                .when().get("student/{id}",id)
                .then().extract().response();
        JsonPath jsonPath = jsonPathConverter(response);
        addResponseToReport(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(jsonPath.getInt("id"), 2);
        Assert.assertEquals(jsonPath.getString("Name"), "scott");
        Assert.assertEquals(jsonPath.getInt("subjectId"), 2);
        Assert.assertEquals(jsonPath.getInt("marks"), 89);


    }
    @Test(priority =2,description = "Create Student details using Post Mesthod")
    public void createStudent() {
        String name ="syam";
        int subjectId =3;
        int marks = 70;

        Response response = given().header("Content-Type","Application.json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(createTestDataForStudent(name,subjectId,marks))
                .when().post("student")
                .then().extract().response();
        JsonPath jsonPath = jsonPathConverter(response);
        addResponseToReport(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertNotNull(response.body());
        Assert.assertEquals(jsonPath.getInt("marks"), marks);
        Assert.assertEquals(jsonPath.getInt("subjectId"), subjectId);
        Assert.assertEquals(jsonPath.getString("Name"), name);
    }


    @Test(priority =3,description = "Update Student details By ID using Put Mesthod")
    public void updateStudentDetailsByID() {
        String name ="ema";
        int subjectId =3;
        int marks = 90;

        Response response = given().header("Content-Type","Application.json").contentType(ContentType.JSON).accept(ContentType.JSON).
                body(updateTestDataForStudent(name,subjectId,marks))
                .when().put("student/6")
                .then().extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
        JsonPath jsonPath = jsonPathConverter(response);
        addResponseToReport(response.asPrettyString());
        Assert.assertEquals(jsonPath.getInt("marks"), marks);
        Assert.assertEquals(jsonPath.getInt("subjectId"), subjectId);
        Assert.assertEquals(jsonPath.getString("Name"), name);


    }

    @Test(priority =4,description = "Delete Student details By ID using Delete Mesthod")
    public void deleteStudentByID() {

        Response response = given()
                .when()
                .delete("student/11")
                .then().extract().response();
        Assert.assertEquals(response.getStatusCode(), 200);
    }


}
