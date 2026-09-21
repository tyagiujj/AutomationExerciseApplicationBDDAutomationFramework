package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;


public class ProductPage {
    WebDriver driver;
    @FindBy(xpath="//a[@href='/products']")
    WebElement productsButton;

    @FindBy(xpath="//h2[normalize-space()='All Products']")
    WebElement allProductsHeader;

    public ProductPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void clickProductsButton(){
        WaitUtils.waitForClickability(driver ,productsButton);
        productsButton.click();
    }
  public boolean isAllproductsHeadersDisplayed(){
        WaitUtils.waitForVisibility(driver, allProductsHeader);
        return allProductsHeader.isDisplayed();
    }
    }

