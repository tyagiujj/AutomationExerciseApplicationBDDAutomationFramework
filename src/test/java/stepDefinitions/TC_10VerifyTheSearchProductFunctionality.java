package stepDefinitions;

import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObjects.ProductPage;
import utils.DriverManager;

public class TC_10VerifyTheSearchProductFunctionality {
    private static final Logger logger = LogManager.getLogger(TC_10VerifyTheSearchProductFunctionality.class);
    WebDriver driver= DriverManager.getDriver();
    ProductPage productPage =new ProductPage(driver);

    @When("Enter product name in search input and click search button")
    public void enter_product_name_in_search_input_and_click_search_button() {
        productPage.searchProduct("Blue Top");
        productPage.clickSubmitSearchButton();
        logger.info("Entered product name in search input and clicked search button.");
    }}
