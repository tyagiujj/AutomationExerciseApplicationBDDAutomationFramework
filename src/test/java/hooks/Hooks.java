package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverManager;

/**
 * Hooks class
 * -------------
 * Contains setup and teardown logic that runs automatically
 * before and after EVERY Cucumber scenario.
 *
 * @Before -> runs before each scenario starts
 * @After  -> runs after each scenario ends
 */
public class Hooks {

    @Before
    public void setUp() {
        WebDriver driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("url"));


    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}