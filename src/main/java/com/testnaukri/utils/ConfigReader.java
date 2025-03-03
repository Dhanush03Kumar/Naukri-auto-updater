package com.testnaukri.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();


    static {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
            properties.load(file);
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("Config file not found or failed to load");
        }
    }

    public static String getProperty(String key){
        String value = properties.getProperty(key);
        if (value == null || value.isEmpty()) {
            // Fallback to environment variables if property is missing
            value = System.getenv(key);
        }
        return value;
    }
}
