package pages;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends TestBase {

    @FindBy(xpath = "//input[@name='quantity_4_16_0_0']")
    @CacheLookup
    WebElement quantityItem;

    @FindBy(xpath = "//input[@name='quantity_4_16_0_0_hidden']")
    @CacheLookup
    WebElement quantity;

    @FindBy(xpath = "//a[@id='5_19_0_0']")
    @CacheLookup
    WebElement removeFirstItemButton;

    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
    @CacheLookup
    WebElement proceedCheckoutButton;


    WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {

        this.driver = driver;

        // Initializing the Page Objects
        PageFactory.initElements(driver, this);
    }

    public void clearQuantityfield(){

        quantityItem.clear();
    }


    public void enterQuantity(String quantity){

        quantityItem.sendKeys(quantity);

    }

    public void clickOnRemoveFirstItemButton(){

        removeFirstItemButton.click();

    }

    public void clickOnProceedCheckoutButton(){

        proceedCheckoutButton.click();
    }




}
