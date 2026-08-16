package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.WaitUtils;

/**
 * RegistrationPage class
 * -------------------------
 * Represents the "Enter Account Information" page on AutomationExercise.
 * Contains all locators and actions for filling the registration form
 * and verifying account creation/deletion.
 *
 * NOTE: This page displays dynamically loading Google Ads that can
 * overlap form elements at click time, causing
 * ElementClickInterceptedException. To make all button clicks robust
 * against this, a shared JavaScript-click helper method is used,
 * combined with explicit waits (WaitUtils) before every interaction.
 */
public class RegistrationPage {
    WebDriver driver;

    @FindBy(xpath = "//b[normalize-space()='Enter Account Information']")
    WebElement enterAccountInfoHeader;

    @FindBy(xpath = "//input[@id='id_gender1']")
    WebElement titleMrRadioButton;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(xpath = "//select[@id='days']")
    WebElement daysDropdown;

    @FindBy(xpath = "//select[@id='months']")
    WebElement monthsDropdown;

    @FindBy(xpath = "//select[@id='years']")
    WebElement yearsDropdown;

    @FindBy(id = "newsletter")
    WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    WebElement specialoffersCheckbox;

    @FindBy(id = "first_name")
    WebElement firstNameInput;

    @FindBy(id = "last_name")
    WebElement lastNameInput;

    @FindBy(id = "company")
    WebElement companyInput;

    @FindBy(id = "address1")
    WebElement address1Input;

    @FindBy(id = "address2")
    WebElement address2Input;

    @FindBy(id = "country")
    WebElement countryDropdown;

    @FindBy(id = "state")
    WebElement stateInput;

    @FindBy(id = "city")
    WebElement cityInput;

    @FindBy(id = "zipcode")
    WebElement zipcodeInput;

    @FindBy(id = "mobile_number")
    WebElement mobileNumberInput;

    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    WebElement createAccountButton;

    @FindBy(xpath = "//b[normalize-space()='Account Created!']")
    WebElement accountCreatedHeader;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueButton;

    @FindBy(xpath = "//a[contains(normalize-space(.),'Logged in as')]")
    WebElement loggedInAsText;

    @FindBy(xpath = "//a[normalize-space()='Delete Account']")
    WebElement deleteAccountButton;

    @FindBy(xpath = "//b[normalize-space()='Account Deleted!']")
    WebElement accountDeletedHeader;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public boolean isEnterAccountInfoHeaderDisplayed() {
        WaitUtils.waitForVisibility(driver, enterAccountInfoHeader);
        return enterAccountInfoHeader.isDisplayed();
    }

    public void selectTitleMr() {
        WaitUtils.waitForVisibility(driver, titleMrRadioButton);
        jsClick(titleMrRadioButton);
    }

    public void enterPassword(String password) {
        WaitUtils.waitForVisibility(driver, passwordInput);
        passwordInput.sendKeys(password);
    }

    public void selectDay(String day) {
        WaitUtils.waitForVisibility(driver, daysDropdown);
        Select select = new Select(daysDropdown);
        select.selectByValue(day);
    }

    public void selectMonth(String month) {
        WaitUtils.waitForVisibility(driver, monthsDropdown);
        Select select = new Select(monthsDropdown);
        select.selectByVisibleText(month);
    }

    public void selectYear(String year) {
        WaitUtils.waitForVisibility(driver, yearsDropdown);
        Select select = new Select(yearsDropdown);
        select.selectByValue(year);
    }

    public void selectNewsletterCheckbox() {
        WaitUtils.waitForVisibility(driver, newsletterCheckbox);
        jsClick(newsletterCheckbox);
    }

    public void selectSpecialOffersCheckbox() {
        WaitUtils.waitForVisibility(driver, specialoffersCheckbox);
        jsClick(specialoffersCheckbox);
    }

    public void enterFirstName(String firstName) {
        WaitUtils.waitForVisibility(driver, firstNameInput);
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WaitUtils.waitForVisibility(driver, lastNameInput);
        lastNameInput.sendKeys(lastName);
    }

    public void enterCompany(String company) {
        WaitUtils.waitForVisibility(driver, companyInput);
        companyInput.sendKeys(company);
    }

    public void enterAddress1(String address1) {
        WaitUtils.waitForVisibility(driver, address1Input);
        address1Input.sendKeys(address1);
    }

    public void enterAddress2(String address2) {
        WaitUtils.waitForVisibility(driver, address2Input);
        address2Input.sendKeys(address2);
    }

    public void selectCountry(String country) {
        WaitUtils.waitForVisibility(driver, countryDropdown);
        Select select = new Select(countryDropdown);
        select.selectByVisibleText(country);
    }

    public void enterState(String state) {
        WaitUtils.waitForVisibility(driver, stateInput);
        stateInput.sendKeys(state);
    }

    public void enterCity(String city) {
        WaitUtils.waitForVisibility(driver, cityInput);
        cityInput.sendKeys(city);
    }

    public void enterZipcode(String zipcode) {
        WaitUtils.waitForVisibility(driver, zipcodeInput);
        zipcodeInput.sendKeys(zipcode);
    }

    public void enterMobileNumber(String mobileNumber) {
        WaitUtils.waitForVisibility(driver, mobileNumberInput);
        mobileNumberInput.sendKeys(mobileNumber);
    }

    public void clickCreateAccountButton() {
        WaitUtils.waitForVisibility(driver, createAccountButton);
        jsClick(createAccountButton);
    }

    public boolean isAccountCreatedHeaderDisplayed() {
        WaitUtils.waitForVisibility(driver, accountCreatedHeader);
        return accountCreatedHeader.isDisplayed();
    }

    public void clickContinueButton() {
        WaitUtils.waitForVisibility(driver, continueButton);
        jsClick(continueButton);
    }

    public boolean isLoggedInAsTextDisplayed() {
        WaitUtils.waitForVisibility(driver, loggedInAsText);
        return loggedInAsText.isDisplayed();
    }

    public void clickDeleteAccountButton() {
        WaitUtils.waitForVisibility(driver, deleteAccountButton);
        jsClick(deleteAccountButton);
    }

    public boolean isAccountDeletedHeaderDisplayed() {
        WaitUtils.waitForVisibility(driver, accountDeletedHeader);
        return accountDeletedHeader.isDisplayed();
    }
}