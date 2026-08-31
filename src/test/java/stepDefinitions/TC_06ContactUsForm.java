package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.ContactUsFormPage;
import utils.DriverManager;
import utils.TestDataGenerator;

public class TC_06ContactUsForm {
    private static final Logger logger = LogManager.getLogger(TC_06ContactUsForm.class);
    WebDriver driver= DriverManager.getDriver();
    ContactUsFormPage contactUsFormPage= new ContactUsFormPage(driver);

    @When("user clicks on Contact Us button")
    public void user_clicks_on_contact_us_button(){
        contactUsFormPage.clickContactUsLink();
        logger.info("Clicked on Contact Us button.");
    }
    @Then("Verify that GET IN TOUCH is visible")
    public void verify_that_get_in_touch_is_visible(){
        Assert.assertTrue(contactUsFormPage.isGetInTouchHeaderDisplayed(), "GET IN TOUCH header is not visible.");
        logger.info("Verified: GET IN TOUCH header is visible.");

}
  @When("user enters name, email, subject and message")
    public void user_enters_name_email_subject_and_message(){
      String randomName= TestDataGenerator.getRandomName();
      contactUsFormPage.enterName(randomName);
      String randomEmail= TestDataGenerator.getRandomEmail();
      contactUsFormPage.enterEmail(randomEmail);
    contactUsFormPage.enterMessage("Hello, this is a test message.");
    contactUsFormPage.enterSubject("Test Subject");
    logger.info("Entered name, email, subject and message.");
  }
    @When("user uploads a file")
    public void user_uploads_a_file() {
        String filePath = System.getProperty("user.dir") + "/UploadFile/sample.pdf";
        contactUsFormPage.uploadFile(filePath);
        logger.info("Uploaded a file: " + filePath);
    }

    @When("user clicks on Submit button")
    public void user_clicks_on_submit_button(){
        contactUsFormPage.clickSubmitButton();
        logger.info("Clicked on Submit button.");
        Alert alert = driver.switchTo().alert();
        alert.accept();
        logger.info("Accepted the alert.");
    }
    @Then("Verify success message 'Success! Your details have been submitted successfully.' is visible")
    public void verify_success_message_is_visible(){
        Assert.assertTrue(contactUsFormPage.isSuccessMessageDisplayed(), "Success message is not visible.");
        logger.info("Verified: Success message is visible.");
    }
    @When("user clicks on Home button and verify that landed to home page successfully")
    public void user_clicks_on_home_button_and_verify_that_landed_to_home_page_successfully(){
        contactUsFormPage.clickHomeButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/"), "Failed to land on home page.");
        logger.info("Verified: Landed on home page successfully.");

    }

}



