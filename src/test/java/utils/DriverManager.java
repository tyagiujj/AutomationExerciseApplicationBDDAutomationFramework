package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverManager {

    private static final Logger logger = LogManager.getLogger(DriverManager.class);
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            String browserName = ConfigReader.get("browser");
            logger.info("Initializing browser: " + browserName);

            WebDriver newDriver;

            // Check if running in CI environment (GitHub Actions sets this automatically)
            boolean isCI = System.getenv("CI") != null;

            if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();

                ChromeOptions options = new ChromeOptions();
                if (isCI) {
                    // No visible display exists on CI runners, so Chrome
                    // must run headless - without rendering an actual window
                    options.addArguments("--headless=new");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--window-size=1920,1080");
                    logger.info("Running in CI environment - Chrome headless mode enabled.");
                }
                newDriver = new ChromeDriver(options);

            } else if (browserName.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();

                FirefoxOptions options = new FirefoxOptions();
                if (isCI) {
                    options.addArguments("--headless");
                }
                newDriver = new FirefoxDriver(options);

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