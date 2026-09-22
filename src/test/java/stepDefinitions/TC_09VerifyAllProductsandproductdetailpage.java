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

    @When("user clicks on Products button")
    public void user_clicks_on_products_button(){
        productPage.clickProductsButton();
        logger.info("Clicked on Products button.");
    }
    @Then("Verify that ALL PRODUCTS heading is visible")
    public void verify_that_all_products_heading_is_visible(){
        Assert.assertTrue(productPage.isAllProductsHeaderDisplayed(), "ALL PRODUCTS heading is not visible.");
    }
    @Then("Verify that product list is displayed")
    public void verify_that_product_list_is_displayed() {
        Assert.assertTrue(productPage.isProductListDisplayed(), "Product list is not displayed!");
        logger.info("Verified: Product list is displayed with " + productPage.getProductCount() + " products.");
    }
    @When("user clicks on 'View Product' of first product")
    public void user_clicks_on_view_product_of_first_product(){
        productPage.clickFirstProduct();
        logger.info("Clicked on 'View Product' of first product.");
    }
    @Then("User is landed to product detail page")
    public void user_is_landed_to_product_detail_page(){
        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/product_details/1"), "User is not landed on the product detail page.");
        logger.info("Verified: User is on the product detail page.");
    }
}


