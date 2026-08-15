package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
 * against this, a shared JavaScript-click helper method is used.
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

    /**
     * Shared helper method - performs a click using JavaScript instead
     * of a normal Selenium click.
     *
     * WHY this exists:
     * AutomationExercise.com shows dynamically loading Google Ads that
     * can overlap buttons at the exact moment of clicking, causing
     * ElementClickInterceptedException with a normal .click(). This
     * method bypasses that by triggering the click directly through
     * the browser's JavaScript engine, which does not depend on
     * screen coordinates or visual overlays.
     *
     * Centralizing this in one method (instead of repeating the same
     * 2 lines in every action method) keeps the class DRY and makes
     * it easy to change the click strategy in one place if needed.
     */
    private void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public boolean isEnterAccountInfoHeaderDisplayed() {
        return enterAccountInfoHeader.isDisplayed();
    }

    public void selectTitleMr() {
        jsClick(titleMrRadioButton);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void selectDay(String day) {
        Select select = new Select(daysDropdown);
        select.selectByValue(day);
    }

    public void selectMonth(String month) {
        Select select = new Select(monthsDropdown);
        select.selectByVisibleText(month);
    }

    public void selectYear(String year) {
        Select select = new Select(yearsDropdown);
        select.selectByValue(year);
    }

    public void selectNewsletterCheckbox() {
        jsClick(newsletterCheckbox);
    }

    public void selectSpecialOffersCheckbox() {
        jsClick(specialoffersCheckbox);
    }

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void enterCompany(String company) {
        companyInput.sendKeys(company);
    }

    public void enterAddress1(String address1) {
        address1Input.sendKeys(address1);
    }

    public void enterAddress2(String address2) {
        address2Input.sendKeys(address2);
    }

    public void selectCountry(String country) {
        Select select = new Select(countryDropdown);
        select.selectByVisibleText(country);
    }

    public void enterState(String state) {
        stateInput.sendKeys(state);
    }

    public void enterCity(String city) {
        cityInput.sendKeys(city);
    }

    public void enterZipcode(String zipcode) {
        zipcodeInput.sendKeys(zipcode);
    }

    public void enterMobileNumber(String mobileNumber) {
        mobileNumberInput.sendKeys(mobileNumber);
    }

    public void clickCreateAccountButton() {
        jsClick(createAccountButton);
    }

    public boolean isAccountCreatedHeaderDisplayed() {
        return accountCreatedHeader.isDisplayed();
    }

    public void clickContinueButton() {
        jsClick(continueButton);
    }

    public boolean isLoggedInAsTextDisplayed() {
        return loggedInAsText.isDisplayed();
    }

    public void clickDeleteAccountButton() {
        jsClick(deleteAccountButton);
    }

    public boolean isAccountDeletedHeaderDisplayed() {
        return accountDeletedHeader.isDisplayed();
    }
}