package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.HomePage;
import utils.DriverManager;

public class TC_07Verify_Test_Cases_Page {
    private static final Logger logger = LogManager.getLogger(TC_07Verify_Test_Cases_Page.class);

    WebDriver driver= DriverManager.getDriver();
    HomePage homePage= new HomePage(driver);

    @When("user clicks on Test Cases button")
    public void user_clicks_on_test_cases_button() {
        homePage.clickTestCasesLink();
        logger.info("Clicked on Test Cases button.");
    }
    @Then("Verify that TEST CASES is visible")
    public void verify_that_test_cases_is_visible() {
        Assert.assertTrue(homePage.isTestCasesTextDisplayed(), "Test Cases Text is not visible!");
        logger.info("Verified: TEST CASES is visible.");
    }
    @Then("Verify user is navigated to test cases page successfully")
    public void verify_user_is_navigated_to_test_cases_page_successfully() {
        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/test_cases"), "User is not navigated to test cases page!");
        logger.info("Verified: User is navigated to test cases page successfully.");
    }
}
