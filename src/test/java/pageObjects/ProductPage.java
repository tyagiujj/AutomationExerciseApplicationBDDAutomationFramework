package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

import java.util.List;

public class ProductPage {
    WebDriver driver;

    @FindBy(xpath = "//a[@href='/products']")
    WebElement productsButton;

    @FindBy(xpath = "//h2[normalize-space()='All Products']")
    WebElement allProductsHeader;

    @FindBy(xpath = "//div[@class='product-image-wrapper']")
    List<WebElement> allProductsList;

    @FindBy(xpath="//a[@href='/product_details/1']")
    WebElement firstProductLink;

   @FindBy(id="search_product")
    WebElement searchProductInput;

   @FindBy(id="submit_search")
   WebElement submitSearchButton;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickProductsButton() {
        WaitUtils.waitForClickability(driver, productsButton);
        productsButton.click();
    }

    public boolean isAllProductsHeaderDisplayed() {
        WaitUtils.waitForVisibility(driver, allProductsHeader);
        return allProductsHeader.isDisplayed();
    }

    public boolean isProductListDisplayed() {
        if (allProductsList.size() > 0) {
            WaitUtils.waitForVisibility(driver, allProductsList.get(0));
        }
        return allProductsList.size() > 0;
    }

    public int getProductCount() {
        return allProductsList.size();
    }
    public void clickFirstProduct(){
        WaitUtils.waitForClickability(driver , firstProductLink);
        firstProductLink.click();
    }
    public void searchProduct(String productName){
        WaitUtils.waitForVisibility(driver , searchProductInput);
        searchProductInput.clear();
        searchProductInput.sendKeys(productName);
    }
    public void clickSubmitSearchButton(){
        WaitUtils.waitForClickability(driver , submitSearchButton);
        submitSearchButton.click();
    }}
