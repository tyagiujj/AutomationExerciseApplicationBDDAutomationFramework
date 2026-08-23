package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import utils.DriverManager;

public class TC_04LogoutUser {
    private static final Logger logger = LogManager.getLogger(TC_04LogoutUser.class);
    WebDriver driver= DriverManager.getDriver();
    RegistrationPage registrationPage=new RegistrationPage(driver);
    LoginPage loginPage=new LoginPage(driver);

    @When("user clicks on Logout button")
    public void click_logout_button(){
        loginPage.clickLogoutButton();
        logger.info("Clicked Logout button.");
    }
    @Then("Verify that Login to your account is visible")
    public void verify_that_login_to_your_account_is_visible() {
        if (loginPage.isLoginToYourAccountHeaderDisplayed()) {
            logger.info("'Login to your account' header is visible.");
        } else {
            logger.error("'Login to your account' header is not visible.");
        }
    }
}