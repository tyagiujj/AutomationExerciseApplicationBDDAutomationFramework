package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import utils.DriverManager;
import utils.TestDataGenerator;

public class TC_01RegisterUser {

    WebDriver driver = DriverManager.getDriver();
    HomePage homePage = new HomePage(driver);
    RegistrationPage registrationPage = new RegistrationPage(driver);

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

    @Then("Verify that ENTER ACCOUNT INFORMATION is visible")
    public void verify_that_enter_account_information_is_visible() {
        Assert.assertTrue(registrationPage.isEnterAccountInfoHeaderDisplayed(), "Enter Account Information section is not visible!");
    }

    @When("user select the title radio button")
    public void user_select_the_title_radio_button() {
        registrationPage.selectTitleMr();
    }

    @And("user enters random password")
    public void user_enters_random_password() {
        String randomPassword = TestDataGenerator.getRandomPassword();
        registrationPage.enterPassword(randomPassword);
    }

    @And("user selects date of birth form dropdown")
    public void user_selects_date_of_birth_form_dropdown() {
        registrationPage.selectDay("10");
    }

    @And("user select month of birth form dropdown")
    public void user_select_month_of_birth_form_dropdown() {
        registrationPage.selectMonth("May");
    }

    @And("user select year of birth form dropdown")
    public void user_select_year_of_birth_form_dropdown() {
        registrationPage.selectYear("1998");
    }

    @And("user selects checkbox for newsletter")
    public void user_selects_checkbox_for_newsletter() {
        registrationPage.selectNewsletterCheckbox();
    }

    @And("user selects checkbox for special offers")
    public void user_selects_checkbox_for_special_offers() {
        registrationPage.selectSpecialOffersCheckbox();
    }

    @And("user enters first name and last name")
    public void user_enters_first_name_and_last_name() {
        String firstName = TestDataGenerator.getRandomFirstName();
        String lastName = TestDataGenerator.getRandomLastName();
        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
    }

    @And("user enters company name")
    public void user_enters_company_name() {
        String company = TestDataGenerator.getRandomCompany();
        registrationPage.enterCompany(company);
    }

    @And("user enters address")
    public void user_enters_address() {
        String address = TestDataGenerator.getRandomAddress();
        registrationPage.enterAddress1(address);
    }

    @And("user enters address2")
    public void user_enters_address2() {
        String address2 = TestDataGenerator.getRandomAddress();
        registrationPage.enterAddress2(address2);
    }

    @And("user selects country from dropdown")
    public void user_selects_country_from_dropdown() {
        registrationPage.selectCountry("India");
    }

    @And("user enters state")
    public void user_enters_state() {
        String state = TestDataGenerator.getRandomState();
        registrationPage.enterState(state);
    }

    @And("user enters city")
    public void user_enters_city() {
        String city = TestDataGenerator.getRandomCity();
        registrationPage.enterCity(city);
    }

    @And("user enters zipcode")
    public void user_enters_zipcode() {
        String zipcode = TestDataGenerator.getRandomZipCode();
        registrationPage.enterZipcode(zipcode);
    }

    @And("user enters mobile number")
    public void user_enters_mobile_number() {
        String mobileNumber = TestDataGenerator.getRandomMobileNumber();
        registrationPage.enterMobileNumber(mobileNumber);
    }

    @And("user clicks on Create Account button")
    public void user_clicks_on_create_account_button() {
        registrationPage.clickCreateAccountButton();
    }

    @Then("Verify that Account Created is visible")
    public void verify_that_account_created_is_visible() {
        Assert.assertTrue(registrationPage.isAccountCreatedHeaderDisplayed(), "Account Created message is not visible!");
    }

    @And("user clicks on Continue button")
    public void user_clicks_on_continue_button() {
        registrationPage.clickContinueButton();
    }

    @And("user clicks on Delete Account button")
    public void user_clicks_on_delete_account_button() {
        registrationPage.clickDeleteAccountButton();
    }

    @Then("Verify that ACCOUNT DELETED! is visible and click on Continue button")
    public void verify_that_account_deleted_is_visible_and_click_on_continue_button() {
        Assert.assertTrue(registrationPage.isAccountDeletedHeaderDisplayed(), "Account Deleted message is not visible!");
        registrationPage.clickContinueButton();
    }
}