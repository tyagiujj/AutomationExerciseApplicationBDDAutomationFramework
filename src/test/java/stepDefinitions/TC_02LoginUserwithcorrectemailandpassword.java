package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import utils.ConfigReader;
import utils.DriverManager;

public class TC_02LoginUserwithcorrectemailandpassword {

    WebDriver driver = DriverManager.getDriver();
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    RegistrationPage registrationPage =new RegistrationPage(driver);

//    @Given("user is on the home page")
//    public void user_is_on_the_home_page() {
//        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page is not displayed!");
//    }

//    @When("user clicks on Signup or Login button")
//    public void user_clicks_on_signup_or_login_button() {
//        homePage.clickSignupLogin();
//    }

    @Then("Login to your account section should be visible")
    public void login_to_your_account_section_should_be_visible() {
        Assert.assertTrue(loginPage.isLoginToYourAccountHeaderDisplayed(), "Login to your account section is not visible!");
    }

    @When("user enters correct email and password")
    public void user_enters_correct_email_and_password() {
        String email = ConfigReader.get("loginemail");
        String password = ConfigReader.get("loginpassword");

        loginPage.enterLoginEmail(email);
        loginPage.enterLoginPassword(password);
    }

    @And("user clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLoginButton();
    }

//    @Then("Verify that Logged in as username is visible")
//    public void verify_that_logged_in_as_username_is_visible() {
//        Assert.assertTrue(registrationPage.isLoggedInAsTextDisplayed(), "Logged in as text is not visible!");


}