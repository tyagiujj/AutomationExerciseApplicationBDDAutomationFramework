package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import utils.DriverManager;

/**
 * CommonSteps class
 * --------------------
 * Contains step definitions that are SHARED across multiple test cases
 * (e.g., navigating to homepage, clicking Signup/Login, verifying
 * "Logged in as" text). Centralizing these avoids duplicate step
 * definitions and prevents accidental cross-class dependencies between
 * unrelated test case classes (like TC_01 and TC_02 relying on each
 * other's methods).
 */
public class CommonSteps {

    WebDriver driver = DriverManager.getDriver();
    HomePage homePage = new HomePage(driver);
    RegistrationPage registrationPage = new RegistrationPage(driver);

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page is not displayed!");
    }

    @When("user clicks on Signup or Login button")
    public void user_clicks_on_signup_or_login_button() {
        homePage.clickSignupLogin();
    }

    @Then("Verify that Logged in as username is visible")
    public void verify_that_logged_in_as_username_is_visible() {
        Assert.assertTrue(registrationPage.isLoggedInAsTextDisplayed(), "Logged in as text is not visible!");
    }
}