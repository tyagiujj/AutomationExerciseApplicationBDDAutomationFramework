package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverManager;

/**
 * Hooks class
 * -------------
 * WHEN to open/close the browser - that's this class's job.
 *
 * @Before -> runs before EVERY scenario starts
 * @After  -> runs after EVERY scenario ends
 */
public class Hooks {

    @Before
    public void setUp() {
        WebDriver driver = DriverManager.getDriver();     // asks DriverManager for browser
        driver.manage().window().maximize();               // extra setup
        driver.get(ConfigReader.get("url"));                // extra setup - navigate to URL
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();                         // tells DriverManager to close it
    }
}