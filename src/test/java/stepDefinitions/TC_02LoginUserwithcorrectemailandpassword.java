package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utils.ConfigReader;
import utils.DriverManager;

public class TC_02LoginUserwithcorrectemailandpassword {

    private static final Logger logger = LogManager.getLogger(TC_02LoginUserwithcorrectemailandpassword.class);

    WebDriver driver = DriverManager.getDriver();
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Then("Login to your account section should be visible")
    public void login_to_your_account_section_should_be_visible() {
        Assert.assertTrue(loginPage.isLoginToYourAccountHeaderDisplayed(), "Login to your account section is not visible!");
        logger.info("Verified: Login to your account section is visible.");
    }

    @When("user enters correct email and password")
    public void user_enters_correct_email_and_password() {
        String email = ConfigReader.get("loginemail");
        String password = ConfigReader.get("loginpassword");

        loginPage.enterLoginEmail(email);
        loginPage.enterLoginPassword(password);
        logger.info("Entered login credentials for email: " + email);
    }

    @And("user clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLoginButton();
        logger.info("Clicked Login button.");
    }
}