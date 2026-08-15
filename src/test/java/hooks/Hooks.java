package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverManager;

import java.io.File;
import java.io.IOException;

public class Hooks {

    @Before
    public void setUp() {
        WebDriver driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("url"));
    }

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverManager.getDriver();

        if (scenario.isFailed()) {
            // Capture as bytes - for future Cucumber HTML report embedding
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotBytes, "image/png", scenario.getName());

            // Also save as a file - so we can visually verify RIGHT NOW,
            // before we build full HTML reporting later in the roadmap
            saveScreenshotToFile(driver, scenario.getName());

            System.out.println("Screenshot captured for failed scenario: " + scenario.getName());
        }

        DriverManager.quitDriver();
    }

    private void saveScreenshotToFile(WebDriver driver, String testName) {
        try {
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";
            File destFile = new File(path);
            FileUtils.copyFile(sourceFile, destFile);
            System.out.println("Screenshot saved to: " + path);
        } catch (IOException e) {
            System.out.println("Could not save screenshot file: " + e.getMessage());
        }
    }
}