package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * DriverManager class
 * ---------------------
 * Purpose: To create and manage a SINGLE WebDriver (browser) instance
 * using Singleton Design Pattern.
 *
 * WHICH browser + HOW to create/destroy it - that's this class's job.
 * (WHEN to create/destroy is decided by Hooks class)
 *
 * Now supports DYNAMIC browser selection based on config.properties.
 */
public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {

            // Read browser name from config.properties (e.g. "chrome" or "firefox")
            String browserName = ConfigReader.get("browser");

            WebDriver newDriver;

            // Decide WHICH browser to launch based on config value
            if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                newDriver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                newDriver = new FirefoxDriver();
            } else {
                // If someone types an unsupported browser name, fail clearly
                throw new RuntimeException("Browser not supported: " + browserName);
            }

            driver.set(newDriver);
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}