package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigReader class
 * ---------------------
 * Purpose: To read values from config.properties file
 * and provide them to the entire framework whenever needed.
 *
 * Why this class exists:
 * Instead of hardcoding values (like URL, browser name) directly
 * inside test code, we store them in one central file (config.properties)
 * and read them using this class. This follows the
 * "Single Responsibility Principle" - this class has only ONE job:
 * read config values.
 */
public class ConfigReader {

    // Properties object will hold all key-value pairs from config.properties
    // 'static' because we want only ONE copy shared across the whole framework
    private static Properties properties;

    // Static block: runs only ONCE, automatically, when this class is
    // used for the first time in the program (no need to call it manually)
    static {
        try {
            // Build the full path to config.properties file
            // System.getProperty("user.dir") gives the project's root folder path
            String path = System.getProperty("user.dir") + "/src/test/resources/config.properties";

            // FileInputStream opens the file so we can read it
            FileInputStream fis = new FileInputStream(path);

            // Create the Properties object
            properties = new Properties();

            // Load file content into the properties object (as key=value pairs)
            properties.load(fis);

        } catch (IOException e) {
            // If file is missing or unreadable, fail immediately with a clear message
            // (better than silently continuing with no config values)
            throw new RuntimeException("Config file not found or unreadable: " + e.getMessage());
        }
    }

    /**
     * get() method
     * -------------
     * Purpose: Any class in the framework can call this method
     * to fetch a value from config.properties using its key.
     *
     * Example usage: ConfigReader.get("url")
     * Returns: "https://www.flipkart.com"
     *
     * @param key - the property name to look up (e.g. "url", "browser")
     * @return the value associated with that key
     */
    public static String get(String key) {
        String value = properties.getProperty(key);

        // If the key doesn't exist in config.properties, fail clearly
        // instead of returning null and causing confusing errors later
        if (value == null) {
            throw new RuntimeException("Key not found in config.properties: " + key);
        }
        return value;
    }
}