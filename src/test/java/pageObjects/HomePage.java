package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//a[normalize-space()='Home']")
    WebElement homeLink;

    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    WebElement signupLoginLink;

    @FindBy(xpath = "//h2[normalize-space()='New User Signup!']")
    WebElement newUserSignupHeader;

    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement signupNameInput;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement signupEmailInput;

    @FindBy(xpath = "//button[normalize-space()='Signup']")
    WebElement signupButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isHomePageDisplayed() {
        WaitUtils.waitForVisibility(driver, homeLink);
        return homeLink.isDisplayed();
    }

    public void clickSignupLogin() {
        WaitUtils.waitForClickability(driver, signupLoginLink);
        signupLoginLink.click();
    }

    public boolean isNewUserSignupHeaderDisplayed() {
        WaitUtils.waitForVisibility(driver, newUserSignupHeader);
        return newUserSignupHeader.isDisplayed();
    }

    public void enterSignupName(String name) {
        WaitUtils.waitForVisibility(driver, signupNameInput);
        signupNameInput.sendKeys(name);
    }

    public void enterSignupEmail(String email) {
        WaitUtils.waitForVisibility(driver, signupEmailInput);
        signupEmailInput.sendKeys(email);
    }

    public void clickSignupButton() {
        WaitUtils.waitForClickability(driver, signupButton);
        signupButton.click();
    }
}