package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import utils.ConfigReader;
import utils.DriverManager;
import utils.TestDataGenerator;

public class TC_05RegisterUserwithexistingemail {

    private static final Logger logger = LogManager.getLogger(TC_05RegisterUserwithexistingemail .class);
    WebDriver driver= DriverManager.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage =new HomePage(driver);
    RegistrationPage registrationPage=new RegistrationPage(driver);


    @When("user enters name and already registered email address")
    public void user_enters_correct_email_and_password() {
        String email = ConfigReader.get("loginemail");
        String randomName= TestDataGenerator.getRandomName();
        homePage.enterSignupName(randomName);
        homePage.enterSignupEmail(email);
        logger.info("Entered login credentials for email: " + email);

}
    @Then("Verify error 'Email Address already exists' is visible")
    public void verify_error_email_address_already_exists_is_visible() {
        Assert.assertTrue(registrationPage.isEmailExistsErrorDisplayed());
        logger.info("Verified: Error 'Email Address already exists' is visible.");
    }
}
