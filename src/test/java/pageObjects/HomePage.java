package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//a[normalize-space()='Home']")
    WebElement homeLink;

    @FindBy(xpath ="//a[normalize-space()='Signup / Login']")
    WebElement signupLoginLink;

    @FindBy(xpath ="//h2[normalize-space()='New User Signup!']")
    WebElement newUserSignupHeader;

    @FindBy(xpath ="//input[@placeholder='Name']")
    WebElement singpuNameInput;

    @FindBy(xpath ="//input[@data-qa='signup-email']")
    WebElement signupEmailInput;

    @FindBy(xpath="//button[normalize-space()='Signup']")
    WebElement signButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isHomePageDisplayed() {
        return homeLink.isDisplayed();
    }
    public void clickSignupLogin(){
        signupLoginLink.click();
    }
    public boolean isNewUserSignupHeaderDisplayed(){
        return newUserSignupHeader.isDisplayed();
    }
    public void enterSignupName(String name){
        singpuNameInput.sendKeys(name);
    }
public void enterSignupEmail(String email){
        signupEmailInput.sendKeys(email);
    }
    public void clickSignupButton(){
        signButton.click();
    }}




