package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class ContactUsFormPage {
    WebDriver driver;
     @FindBy(xpath="//a[normalize-space()='Contact us']")
     WebElement contactUsLink;

     @FindBy(xpath="//h2[normalize-space()='Get In Touch']")
     WebElement getInTouchHeader;

     @FindBy(xpath="//input[@placeholder='Name']")
     WebElement nameInput;

     @FindBy(xpath="//input[@placeholder='Email']")
     WebElement emailInput;

     @FindBy(xpath="//input[@placeholder='Subject']")
    WebElement subjectInput;

     @FindBy(xpath="//textarea[@id='message']")
     WebElement messageInput;

     @FindBy(xpath="//input[@name='upload_file']")
     WebElement uploadFileInput;

     @FindBy(xpath="//input[@name='submit']")
     WebElement submitButton;

     @FindBy(xpath="//div[@class='status alert alert-success']")
     WebElement successMessage;

     @FindBy(xpath="//span[normalize-space()='Home']")
     WebElement homeButton;

     public ContactUsFormPage (WebDriver driver){
         this.driver=driver;
         PageFactory.initElements(driver, this);
     }
     public void clickContactUsLink(){
         WaitUtils.waitForClickability(driver, contactUsLink);
         contactUsLink.click();

}
    public boolean isGetInTouchHeaderDisplayed(){
        WaitUtils.waitForVisibility(driver, getInTouchHeader);
        return getInTouchHeader.isDisplayed();
    }
    public void enterName(String name){
        WaitUtils.waitForVisibility(driver, nameInput);
        nameInput.sendKeys(name);
    }
    public void enterEmail(String email){
        WaitUtils.waitForVisibility(driver, emailInput);
        emailInput.sendKeys(email);
    }
    public void enterSubject(String subject){
        WaitUtils.waitForVisibility(driver, subjectInput);
        subjectInput.sendKeys(subject);
    }
    public void enterMessage(String message) {
        WaitUtils.waitForVisibility(driver, messageInput);
        messageInput.sendKeys(message);
    }
    public void uploadFile(String filePath){
        WaitUtils.waitForVisibility(driver, uploadFileInput);
        uploadFileInput.sendKeys(filePath);
    }
    public void clickSubmitButton(){
        WaitUtils.waitForClickability(driver, submitButton);
        submitButton.click();
     }
     public boolean isSuccessMessageDisplayed(){
         WaitUtils.waitForVisibility(driver, successMessage);
         return successMessage.isDisplayed();
     }
     public void clickHomeButton(){
         WaitUtils.waitForClickability(driver, homeButton);
         homeButton.click();
     }}



