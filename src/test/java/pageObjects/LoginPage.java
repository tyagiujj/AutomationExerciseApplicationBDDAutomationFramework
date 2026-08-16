package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

/**
 * LoginPage class
 * ------------------
 * Represents the Login form section on AutomationExercise.
 * Contains locators and actions for logging in with existing credentials.
 */
public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//h2[normalize-space()='Login to your account']")
    WebElement loginToYourAccountHeader;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement loginEmailInput;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElement loginPasswordInput;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLoginToYourAccountHeaderDisplayed() {
        WaitUtils.waitForVisibility(driver, loginToYourAccountHeader);
        return loginToYourAccountHeader.isDisplayed();
    }

    public void enterLoginEmail(String email) {
        WaitUtils.waitForVisibility(driver, loginEmailInput);
        loginEmailInput.sendKeys(email);
    }

    public void enterLoginPassword(String password) {
        WaitUtils.waitForVisibility(driver, loginPasswordInput);
        loginPasswordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        WaitUtils.waitForClickability(driver, loginButton);
        loginButton.click();
    }
}