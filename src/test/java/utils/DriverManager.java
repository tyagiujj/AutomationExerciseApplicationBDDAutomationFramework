package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager {

    private static final Logger logger = LogManager.getLogger(DriverManager.class);
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            String browserName = ConfigReader.get("browser");
            logger.info("Initializing browser: " + browserName);

            WebDriver newDriver;

            if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                newDriver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                newDriver = new FirefoxDriver();
            } else {
                logger.error("Browser not supported: " + browserName);
                throw new RuntimeException("Browser not supported: " + browserName);
            }

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
            logger.info("Driver quit successfully.");
        }
    }
}