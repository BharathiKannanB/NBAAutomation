package com.veeva.utility;

import java.util.*;

/**
 * Utility class for handling test data.
 * This class provides methods to read and manage test data from YAML files.
 */
public class TestDataUtility {

    private static final HashMap<String, List<HashMap<String, String>>> overAllTestData = new HashMap<>();

    public TestDataUtility(){}

    private HashMap<String, Object> readTestData(){
        return new YamlUtility(this.getClass()
                .getClassLoader()
                .getResourceAsStream("TestData.yaml")).getAllTestData();
    }


    public void setTestData() {
        HashMap<String, Object> getAllTestData = readTestData();
        String environment = new PropertiesUtility().getProperty("environment", "Stage");
        for (Map.Entry<String, Object> each : getAllTestData.entrySet()) {
            List<HashMap<String, String>> testDataSet = (List<HashMap<String, String>>) Optional.ofNullable(each.getValue())
                    .map(value -> (LinkedHashMap<String, Object>) value)
                    .map(linkedHashMap -> (List<HashMap<String, String>>) linkedHashMap.get(environment))
                    .orElse(Collections.singletonList(new HashMap<>()));
            List<HashMap<String, String>> combined = ((ArrayList<String>) ((LinkedHashMap<String, Object>) (each.getValue())).get("Browser")).stream()
                    .flatMap(browserName -> testDataSet.stream().map(map -> {
                        HashMap<String, String> newMap = new HashMap<>(map);
                        newMap.put("Browser", browserName);
                        return newMap;
                    })).toList();
            overAllTestData.put(each.getKey(), combined);
        }
    }


    public List<HashMap<String, String>> getTestData(String testCase){
        return overAllTestData.get(testCase);
    }

}
