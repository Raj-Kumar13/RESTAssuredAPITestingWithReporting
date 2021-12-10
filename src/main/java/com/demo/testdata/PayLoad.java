package com.demo.testdata;

import java.util.HashMap;
import java.util.Map;

public class PayLoad {
    public static Map<String,String> createUserDataForTesting(String name, String job) {
        Map <String ,String> map = new HashMap<>();
        map.put("name",name);
        map.put("job", job);
        return map;

    }

    public static Map<String,String> updateUserDataForTesting(String name,String job) {
        Map <String ,String> map = new HashMap<>();
        map.put("name",name);
        map.put("job", job);
        return map;

    }

}
