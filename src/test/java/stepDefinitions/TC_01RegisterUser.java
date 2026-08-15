package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.HomePage;
import utils.DriverManager;
import utils.TestDataGenerator;

public class TC_01RegisterUser {

    WebDriver driver = DriverManager.getDriver();
    HomePage homePage = new HomePage(driver);

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page is not displayed!");
    }

    @When("user clicks on Signup or Login button")
    public void user_clicks_on_signup_or_login_button() {
        homePage.clickSignupLogin();
    }

    @Then("New User Signup section should be visible")
    public void new_user_signup_section_should_be_visible() {
        Assert.assertTrue(homePage.isNewUserSignupHeaderDisplayed(), "New User Signup section is not visible!");
    }

    @When("user enters random name and email for signup")
    public void user_enters_random_name_and_email_for_signup() {
        String randomName = TestDataGenerator.getRandomName();
        String randomEmail = TestDataGenerator.getRandomEmail();

        homePage.enterSignupName(randomName);
        homePage.enterSignupEmail(randomEmail);
    }

    @And("user clicks on Signup button")
    public void user_clicks_on_signup_button() {
        homePage.clickSignupButton();
    }
}