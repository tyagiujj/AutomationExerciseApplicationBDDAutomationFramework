package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import utils.DriverManager;

public class CommonSteps {

    private static final Logger logger = LogManager.getLogger(CommonSteps.class);

    WebDriver driver = DriverManager.getDriver();
    HomePage homePage = new HomePage(driver);
    RegistrationPage registrationPage = new RegistrationPage(driver);

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page is not displayed!");
        logger.info("Verified: Home page is displayed.");
    }

    @When("user clicks on Signup or Login button")
    public void user_clicks_on_signup_or_login_button() {
        homePage.clickSignupLogin();
        logger.info("Clicked Signup/Login button.");
    }

    @Then("Verify that Logged in as username is visible")
    public void verify_that_logged_in_as_username_is_visible() {
        Assert.assertTrue(registrationPage.isLoggedInAsTextDisplayed(), "Logged in as text is not visible!");
        logger.info("Verified: 'Logged in as' text is displayed.");
    }
}