package com.automation.propertyreader;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class PropertiesFileReader {
    private static Properties properties;

    private PropertiesFileReader() {
    }

    @SneakyThrows
    private static void init() {
        BufferedReader reader;
        String PROPERTIES_FILE_PATH = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "test.properties";
        reader = new BufferedReader(new FileReader(PROPERTIES_FILE_PATH));
        properties = new Properties();
        properties.load(reader);
        reader.close();

    }

    public static String getProperty(String key) {
        if (properties == null) init();
        String property = properties.getProperty(key);
        if (property != null) {
            return property;
        } else {
            throw new RuntimeException("The " + key + " property is not specified within properties file");
        }
    }
}