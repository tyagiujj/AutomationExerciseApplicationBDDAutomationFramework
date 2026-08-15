package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import utils.DriverManager;
import utils.TestDataGenerator;

public class TC_01RegisterUser {

    private static final Logger logger = LogManager.getLogger(TC_01RegisterUser.class);

    WebDriver driver = DriverManager.getDriver();
    HomePage homePage = new HomePage(driver);
    RegistrationPage registrationPage = new RegistrationPage(driver);

    @Then("New User Signup section should be visible")
    public void new_user_signup_section_should_be_visible() {
        Assert.assertTrue(homePage.isNewUserSignupHeaderDisplayed(), "New User Signup section is not visible!");
        logger.info("Verified: New User Signup section is visible.");
    }

    @When("user enters random name and email for signup")
    public void user_enters_random_name_and_email_for_signup() {
        String randomName = TestDataGenerator.getRandomName();
        String randomEmail = TestDataGenerator.getRandomEmail();

        homePage.enterSignupName(randomName);
        homePage.enterSignupEmail(randomEmail);
        logger.info("Entered signup name: " + randomName + " and email: " + randomEmail);
    }

    @And("user clicks on Signup button")
    public void user_clicks_on_signup_button() {
        homePage.clickSignupButton();
        logger.info("Clicked Signup button.");
    }

    @Then("Verify that ENTER ACCOUNT INFORMATION is visible")
    public void verify_that_enter_account_information_is_visible() {
        Assert.assertTrue(registrationPage.isEnterAccountInfoHeaderDisplayed(), "Enter Account Information section is not visible!");
        logger.info("Verified: Enter Account Information section is visible.");
    }

    @When("user select the title radio button")
    public void user_select_the_title_radio_button() {
        registrationPage.selectTitleMr();
        logger.info("Selected title radio button (Mr).");
    }

    @And("user enters random password")
    public void user_enters_random_password() {
        String randomPassword = TestDataGenerator.getRandomPassword();
        registrationPage.enterPassword(randomPassword);
        logger.info("Entered random password.");
    }

    @And("user selects date of birth form dropdown")
    public void user_selects_date_of_birth_form_dropdown() {
        registrationPage.selectDay("10");
        logger.info("Selected day: 10");
    }

    @And("user select month of birth form dropdown")
    public void user_select_month_of_birth_form_dropdown() {
        registrationPage.selectMonth("May");
        logger.info("Selected month: May");
    }

    @And("user select year of birth form dropdown")
    public void user_select_year_of_birth_form_dropdown() {
        registrationPage.selectYear("1998");
        logger.info("Selected year: 1998");
    }

    @And("user selects checkbox for newsletter")
    public void user_selects_checkbox_for_newsletter() {
        registrationPage.selectNewsletterCheckbox();
        logger.info("Selected newsletter checkbox.");
    }

    @And("user selects checkbox for special offers")
    public void user_selects_checkbox_for_special_offers() {
        registrationPage.selectSpecialOffersCheckbox();
        logger.info("Selected special offers checkbox.");
    }

    @And("user enters first name and last name")
    public void user_enters_first_name_and_last_name() {
        String firstName = TestDataGenerator.getRandomFirstName();
        String lastName = TestDataGenerator.getRandomLastName();
        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
        logger.info("Entered first name: " + firstName + ", last name: " + lastName);
    }

    @And("user enters company name")
    public void user_enters_company_name() {
        String company = TestDataGenerator.getRandomCompany();
        registrationPage.enterCompany(company);
        logger.info("Entered company name: " + company);
    }

    @And("user enters address")
    public void user_enters_address() {
        String address = TestDataGenerator.getRandomAddress();
        registrationPage.enterAddress1(address);
        logger.info("Entered address: " + address);
    }

    @And("user enters address2")
    public void user_enters_address2() {
        String address2 = TestDataGenerator.getRandomAddress();
        registrationPage.enterAddress2(address2);
        logger.info("Entered address2: " + address2);
    }

    @And("user selects country from dropdown")
    public void user_selects_country_from_dropdown() {
        registrationPage.selectCountry("India");
        logger.info("Selected country: India");
    }

    @And("user enters state")
    public void user_enters_state() {
        String state = TestDataGenerator.getRandomState();
        registrationPage.enterState(state);
        logger.info("Entered state: " + state);
    }

    @And("user enters city")
    public void user_enters_city() {
        String city = TestDataGenerator.getRandomCity();
        registrationPage.enterCity(city);
        logger.info("Entered city: " + city);
    }

    @And("user enters zipcode")
    public void user_enters_zipcode() {
        String zipcode = TestDataGenerator.getRandomZipCode();
        registrationPage.enterZipcode(zipcode);
        logger.info("Entered zipcode: " + zipcode);
    }

    @And("user enters mobile number")
    public void user_enters_mobile_number() {
        String mobileNumber = TestDataGenerator.getRandomMobileNumber();
        registrationPage.enterMobileNumber(mobileNumber);
        logger.info("Entered mobile number: " + mobileNumber);
    }

    @And("user clicks on Create Account button")
    public void user_clicks_on_create_account_button() {
        registrationPage.clickCreateAccountButton();
        logger.info("Clicked Create Account button.");
    }

    @Then("Verify that Account Created is visible")
    public void verify_that_account_created_is_visible() {
        Assert.assertTrue(registrationPage.isAccountCreatedHeaderDisplayed(), "Account Created message is not visible!");
        logger.info("Verified: Account Created message is visible.");
    }

    @And("user clicks on Continue button")
    public void user_clicks_on_continue_button() {
        registrationPage.clickContinueButton();
        logger.info("Clicked Continue button.");
    }

    @And("user clicks on Delete Account button")
    public void user_clicks_on_delete_account_button() {
        registrationPage.clickDeleteAccountButton();
        logger.info("Clicked Delete Account button.");
    }

    @Then("Verify that ACCOUNT DELETED! is visible and click on Continue button")
    public void verify_that_account_deleted_is_visible_and_click_on_continue_button() {
        Assert.assertTrue(registrationPage.isAccountDeletedHeaderDisplayed(), "Account Deleted message is not visible!");
        logger.info("Verified: Account Deleted message is visible.");
        registrationPage.clickContinueButton();
        logger.info("Clicked Continue button after account deletion.");
    }
}