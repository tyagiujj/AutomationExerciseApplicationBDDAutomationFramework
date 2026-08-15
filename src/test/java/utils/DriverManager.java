package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * DriverManager class
 * ----------------------
 * Creates and manages a single WebDriver instance using the
 * Singleton Design Pattern. Supports dynamic browser selection
 * based on config.properties.
 */
public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {

            String browserName = ConfigReader.get("browser");
            WebDriver newDriver;

            if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                newDriver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                newDriver = new FirefoxDriver();
            } else {
                throw new RuntimeException("Browser not supported: " + browserName);
            }

            // Implicit wait - tells the driver to wait for elements
            // to appear before throwing "element not found" errors.
            // Value is read from config.properties (not hardcoded).
            int waitTime = Integer.parseInt(ConfigReader.get("implicitWait"));
            newDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));

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