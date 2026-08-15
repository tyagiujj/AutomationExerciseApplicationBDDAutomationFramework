package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Logger logger = LogManager.getLogger(ConfigReader.class);
    private static Properties properties;

    static {
        try {
            String path = System.getProperty("user.dir") + "/src/test/resources/config.properties";
            FileInputStream fis = new FileInputStream(path);
            properties = new Properties();
            properties.load(fis);
            logger.info("Config file loaded successfully.");
        } catch (IOException e) {
            logger.error("Config file not found or unreadable: " + e.getMessage());
            throw new RuntimeException("Config file not found or unreadable: " + e.getMessage());
        }
    }

    public static String get(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            logger.error("Key not found in config.properties: " + key);
            throw new RuntimeException("Key not found in config.properties: " + key);
        }
        return value;
    }
}