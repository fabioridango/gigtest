package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.SearchResultPage;


public class SearchProductStepDefs {

    public HomePage homePage;
    public TestBase testBase;
    public SearchResultPage searchResultPage;
    public WebDriver driver;


    @Given("^I am on home page$")
    public void iAmOnHomePage() {

        testBase = new TestBase();

        driver = testBase.initialization();

        homePage = new HomePage(driver);

        Assert.assertEquals("My Store", homePage.getTitle());
    }

    @When("^I search by product category \"([^\"]*)\"$")
    public void iSearchByProductCategory(String productCategory) throws Throwable {

        homePage.enterSearchInput(productCategory);

        searchResultPage = homePage.clickOnSearchButton();

    }

    @Then("^I should see the search result page with the product list$")
    public void iShouldSeeTheSearchResultPageWithTheProductList() {

        Assert.assertTrue(searchResultPage.checkProductList());

        TestBase.closeBrowser();

    }


    @Then("^I should see the message \"([^\"]*)\" \"([^\"]*)\"$")
    public void iShouldSeeTheMessage(String alertMessage, String productCategory) throws Throwable {

        Assert.assertEquals(alertMessage + " " + '"' + productCategory + '"', searchResultPage.getAlertMessage());

        TestBase.closeBrowser();

    }


    @When("^I search with blank search input$")
    public void iSearchWithBlankSearchInput() {

        homePage.clickOnSearchButton();
    }

    @Then("^I should see the message \"([^\"]*)\"$")
    public void iShouldSeeTheMessage(String alertMessage) throws Throwable {

        Assert.assertEquals(alertMessage,searchResultPage.getAlertMessage());

        TestBase.closeBrowser();
    }
}
