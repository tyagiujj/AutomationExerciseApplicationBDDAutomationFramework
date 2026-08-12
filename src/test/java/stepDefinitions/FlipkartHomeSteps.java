package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverManager;

public class FlipkartHomeSteps {

    // Same driver instance created by Hooks (Singleton - same object everywhere)
    WebDriver driver = DriverManager.getDriver();

    @Given("user is on the Flipkart homepage")
    public void user_is_on_the_flipkart_homepage() {
        // Nothing extra needed - Hooks @Before already opened the URL
        System.out.println("User is on Flipkart homepage");
    }

    @Then("the page title should contain {string}")
    public void the_page_title_should_contain(String expectedTitle) {
        String actualTitle = driver.getTitle();
        System.out.println("Actual Title: " + actualTitle);

        Assert.assertTrue(actualTitle.contains(expectedTitle),
                "Title did not contain expected text!");
    }
}