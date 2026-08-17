package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utils.DriverManager;
import utils.TestDataGenerator;

public class TC_03LoginUserwithincorrectemailandpassword {

    private static final Logger logger = LogManager.getLogger(TC_03LoginUserwithincorrectemailandpassword.class);

    WebDriver driver = DriverManager.getDriver();
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @When("user enters incorrect email and password")
    public void user_enters_incorrect_and_password() {
        String randomEmail = TestDataGenerator.getRandomEmail();
        String randomPassword = TestDataGenerator.getRandomPassword();

        loginPage.enterLoginEmail(randomEmail);
        loginPage.enterLoginPassword(randomPassword);
        logger.info("Entered incorrect email: " + randomEmail + " and random password.");
    }

    @Then("Verify error Your email or password is incorrect is visible")
    public void verify_error_your_email_or_password_is_incorrect_is_visible() {
        Assert.assertTrue(loginPage.isInvalidEmailAndPasswordMessageDisplayed(), "Invalid email/password error message is not visible!");
        logger.info("Verified: Invalid email/password error message is displayed.");
    }
}