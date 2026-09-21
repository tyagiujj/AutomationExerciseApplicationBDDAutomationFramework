package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.ProductPage;
import utils.DriverManager;

public class TC_09VerifyAllProductsandproductdetailpage {
    private static final Logger logger = LogManager.getLogger(TC_09VerifyAllProductsandproductdetailpage.class);
    WebDriver driver= DriverManager.getDriver();
    ProductPage productPage=new ProductPage(driver);

    @When("user clicks on  Products button")
    public void user_clicks_on_products_button(){
        productPage.clickProductsButton();
        logger.info("Clicked on Products button.");
    }
    @Then("Verify that ALL PRODUCTS heading is visible")
    public void verify_that_all_products_heading_is_visible(){
        Assert.assertTrue(productPage.isAllproductsHeadersDisplayed(), "ALL PRODUCTS heading is not visible.");
    }}


