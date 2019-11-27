package pages;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends TestBase {

    @FindBy(xpath = "//p[contains(@class,'alert alert-warning')]")
    @CacheLookup
    WebElement alertMessage;

    @FindBy(xpath = "//ul[@class='product_list grid row']")
    @CacheLookup
    WebElement productList;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[3]/div[1]/div[2]/a[1]")
    @CacheLookup
    WebElement firstItem;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[2]/div[1]/div[1]/div[3]/div[1]/div[2]/a[1]")
    @CacheLookup
    WebElement secondItem;

    @FindBy(xpath = "//li[@id='list']")
    @CacheLookup
    WebElement listView;

    @FindBy(xpath = "//span[@class='continue btn btn-default button exclusive-medium']")
    @CacheLookup
    WebElement continueToShopping;

    @FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
    @CacheLookup
    WebElement proceedToCheckout;


    WebDriver driver;


    public SearchResultPage(WebDriver driver) {

        this.driver = driver;

        // Initializing the Page Objects
        PageFactory.initElements(driver, this);
    }

    public String getAlertMessage(){

        return alertMessage.getText();
    }

    public Boolean checkProductList(){

        return productList.isDisplayed();
    }

    public void clickOnListView(){

        listView.click();

    }

    public void addToCartItem(){

        firstItem.click();

        continueToShopping.click();

        secondItem.click();

    }

    public void clickOnProceedCheckoutButton(){

        proceedToCheckout.click();

    }
}
