package com.sdet.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestDataReader {
    
    private static Properties properties;
    
    static {
        try {
            properties = new Properties();
            InputStream input = TestDataReader.class
                .getClassLoader()
                .getResourceAsStream("testdata.properties");
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String get(String key) {
        return properties.getProperty(key);
    }
}