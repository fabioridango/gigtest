package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AuthenticationPage;
import pages.HomePage;
import pages.SearchResultPage;
import pages.ShoppingCartPage;


public class ShoppingCartStepDefs {

    public static HomePage homePage;
    public SearchResultPage searchResultPage;
    public ShoppingCartPage shoppingCartPage;
    public AuthenticationPage authenticationPage;
    public WebDriver driver;

    @Given("^I navigate on home page$")
    public void iNavigateOnHomePage() {

        TestBase testBase = new TestBase();

        driver = testBase.initialization();

        homePage = new HomePage(driver);

        Assert.assertEquals("My Store", homePage.getTitle());

    }

    @When("^I add on shopping cart the first and second item in the product list of the product category \"([^\"]*)\"$")
    public void iAddOnShoppingCartTheFirstAndSecondItemInTheProductListOfTheProductCategory(String productCategory) throws Throwable {

        homePage.enterSearchInput(productCategory);

        searchResultPage = homePage.clickOnSearchButton();

        searchResultPage.clickOnListView();

        searchResultPage.addToCartItem();

        searchResultPage.clickOnProceedCheckoutButton();

    }

    @And("^I change the quantity to (\\d+) of the second item in the cart$")
    public void iChangeTheQuantityToOfTheSecondItemInTheCart(int quantityItem) {

        shoppingCartPage = new ShoppingCartPage(driver);

        shoppingCartPage.clearQuantityfield();

        shoppingCartPage.enterQuantity(String.valueOf(quantityItem));

    }

    @And("^I remove the first item$")
    public void iRemoveTheFirstItem() {

        shoppingCartPage.clickOnRemoveFirstItemButton();

    }


    @Then("^the first item is removed from the shopping cart$")
    public void theFirstItemIsRemovedFromTheShoppingCart() {

    }


    @And("^I proceed to checkout in the my cart$")
    public void iProceedToCheckoutInTheMyCart() {

        shoppingCartPage.clickOnProceedCheckoutButton();

    }


    @Then("^I should be redirected on authentication page$")
    public void iShouldBeRedirectedOnAuthenticationPage() {

        authenticationPage = new AuthenticationPage(driver);

        Assert.assertEquals("Login - My Store", authenticationPage.getTitle());

        TestBase.closeBrowser();

    }
}

