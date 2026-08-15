package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverManager;

import java.io.File;
import java.io.IOException;

public class Hooks {

    // Logger instance - tied to this specific class (Hooks.class)
    // so every log message automatically shows "Hooks" as its source
    private static final Logger logger = LogManager.getLogger(Hooks.class);

    @Before
    public void setUp() {
        WebDriver driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("url"));

        logger.info("Browser launched and navigated to: " + ConfigReader.get("url"));
    }

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverManager.getDriver();

        if (scenario.isFailed()) {
            logger.error("Scenario FAILED: " + scenario.getName());

            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotBytes, "image/png", scenario.getName());

            saveScreenshotToFile(driver, scenario.getName());
        } else {
            logger.info("Scenario PASSED: " + scenario.getName());
        }

        DriverManager.quitDriver();
        logger.info("Browser closed.");
    }

    private void saveScreenshotToFile(WebDriver driver, String testName) {
        try {
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";
            File destFile = new File(path);
            FileUtils.copyFile(sourceFile, destFile);
            logger.info("Screenshot saved to: " + path);
        } catch (IOException e) {
            logger.error("Could not save screenshot file: " + e.getMessage());
        }
    }
}