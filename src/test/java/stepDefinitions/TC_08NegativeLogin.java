package stepDefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.LoginPage;
import utils.DriverManager;

public class TC_08NegativeLogin {

    private static final Logger logger = LogManager.getLogger(TC_08NegativeLogin.class);

    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @When("user enters {string} and {string}")
    public void user_enters_email_and_password(String email, String password) {
        loginPage.enterLoginEmail(email);
        loginPage.enterLoginPassword(password);
        logger.info("Entered email: " + email + " and password: " + password);
    }

    @Then("Verify that error message is visible")
    public void verify_that_error_message_is_visible() {
        Assert.assertTrue(loginPage.isInvalidEmailAndPasswordMessageDisplayed(),
                "Error message is not visible!");
        logger.info("Verified: Error message is displayed.");
    }
}