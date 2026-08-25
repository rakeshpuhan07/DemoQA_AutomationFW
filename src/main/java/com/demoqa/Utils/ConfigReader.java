package com.demoqa.Utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {

        try (InputStream inputStream =
                     ConfigReader.class.getClassLoader()
                             .getResourceAsStream("config.properties")) {

            if (inputStream == null) {

                throw new RuntimeException(
                        "config.properties file not found");
            }

            properties.load(inputStream);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Failed to load config.properties", e);
        }
    }

    private ConfigReader() {
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static int getIntProperty(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }

    public static boolean getBooleanProperty(String key) {
        return Boolean.parseBoolean(properties.getProperty(key));
    }
}
