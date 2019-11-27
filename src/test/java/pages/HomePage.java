package pages;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase{

    @FindBy(xpath = "//input[@id='search_query_top']")
    @CacheLookup
    WebElement searchField;

    @FindBy(xpath = "//button[@name='submit_search']")
    @CacheLookup
    WebElement searchButton;

    @FindBy(xpath = "//a[@class='login']")
    @CacheLookup
    WebElement signInLink;

    @FindBy(xpath = "//div[@class='shopping_cart']")
    @CacheLookup
    WebElement shoppingCart;

    WebDriver driver;


    public HomePage(WebDriver driver) {

        this.driver = driver;

        // Initializing the Page Objects
        PageFactory.initElements(driver, this);
    }

    public void clearSearchField(){

        searchField.clear();
    }

    public void enterSearchInput(String searchInput){

        searchField.sendKeys(searchInput);
    }

    public SearchResultPage clickOnSearchButton(){

        searchButton.click();

        return new SearchResultPage(driver);
    }

    public void clickOnSinInLink(){

        signInLink.click();
    }

    public String getTitle(){

        return driver.getTitle();
    }

}
