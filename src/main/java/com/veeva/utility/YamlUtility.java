package com.veeva.utility;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.HashMap;

/**
 * Utility class for handling YAML files.
 * This class provides methods to read and process data from YAML files.
 */
public class YamlUtility {
    private static HashMap<String, Object> yaml;

   
    YamlUtility(InputStream inputStream){
        yaml = new Yaml().load(inputStream);
    }

  
    public Object readYaml(String key){
        return yaml.getOrDefault(key, "");
    }


    public HashMap<String, Object> getAllTestData(){
        return yaml;
    }
}
