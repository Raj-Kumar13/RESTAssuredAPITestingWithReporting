package com.demo.LocalAPITestData.TestData;

import java.util.HashMap;
import java.util.Map;

public class PayLoad {

    public static Map<String,Object> createTestDataForStudent(String name, int subjectId, int marks) {
        Map<String,Object> testData = new HashMap<>();
        testData.put("Name",name);
        testData.put("subjectId", subjectId);
        testData.put("marks", marks);

        return testData;
    }


    public static Map<String,Object> updateTestDataForStudent(String name,int subjectId,int marks) {
        Map<String,Object> testData = new HashMap<>();
        testData.put("Name",name);
        testData.put("subjectId", subjectId);
        testData.put("marks", marks);

        return testData;
    }

    public static Map<String,Object> createTestDataForSubject(String subjectName) {
        Map<String,Object> testData = new HashMap<>();
        testData.put("subjectName",subjectName);
        return testData;
    }

    public static Map<String,Object> updateTestDataForSubject(String subjectName) {
        Map<String,Object> testData = new HashMap<>();
        testData.put("subjectName",subjectName);
        return testData;
    }

}
