package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.AuthenticationPage;

public class UserAuthenticationStepDefs {

    public static HomePage homePage;
    public AuthenticationPage authenticationPage;
    public WebDriver driver;


    @Given("^I am on authenticate page$")
    public void iAmOnAuthenticatePage() {

        TestBase testBase = new TestBase();

        driver = testBase.initialization();

        homePage = new HomePage(driver);

        Assert.assertEquals("My Store", homePage.getTitle());

        homePage.clickOnSinInLink();

        authenticationPage = new AuthenticationPage(driver);

        Assert.assertEquals("Login - My Store", authenticationPage.getTitle());
    }


    @When("^I sign in with email address \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iSignInWithEmailAddressAndPassword(String emailAddress, String password) throws Throwable {

        authenticationPage.enterEmailAddress(emailAddress);

        authenticationPage.enterPassword(password);

        authenticationPage.clickOnSignIn();

    }


    @Then("^I should be redirected on my account page$")
    public void iShouldBeRedirectedOnMyAccountPage() {

        Assert.assertEquals("My account - My Store", authenticationPage.getTitle());

        TestBase.closeBrowser();
    }


    @Then("^I should see the \"([^\"]*)\" error message$")
    public void iShouldSeeTheErrorMessage(String alertMessage) throws Throwable {

        Assert.assertEquals("Login - My Store", authenticationPage.getTitle());

        Assert.assertEquals("There is 1 error" + System.lineSeparator() + alertMessage, authenticationPage.getAlertAlreadyRegisteredForm());

        TestBase.closeBrowser();

    }

    @When("^I sign in with blank email address and password$")
    public void iSignInWithBlankEmailAddressAndPassword() {

        authenticationPage.clickOnSignIn();
    }


    @When("^I sign in with email address \"([^\"]*)\" and blank password$")
    public void iSignInWithEmailAddressAndBlankPassword(String emailAddress) throws Throwable {

        authenticationPage.enterEmailAddress(emailAddress);

        authenticationPage.clickOnSignIn();
    }


    @When("^I sign in with blank email address and password \"([^\"]*)\"$")
    public void iSignInWithBlankEmailAddressAndPassword(String arg0) throws Throwable {

        authenticationPage.clickOnSignIn();

    }

    @When("^I want create an account with email address \"([^\"]*)\"$")
    public void iWantCreateAnAccountWithEmailAddress(String email) throws Throwable {

        authenticationPage.enterEmailAddressCreateAccount(email);

        authenticationPage.clickOnCreateAccountButton();

    }

    @Then("^I should be redirected on account creation page$")
    public void iShouldBeRedirectedOnAccountCreationPage() {

        Assert.assertEquals("Login - My Store", authenticationPage.getTitle());

        TestBase.closeBrowser();
    }

    @Then("^I should see an \"([^\"]*)\" error message$")
    public void iShouldSeeAnErrorMessage(String alertMessage) throws Throwable {

        Assert.assertEquals("Login - My Store", authenticationPage.getTitle());

        System.out.println(authenticationPage.getAlertCreateAccountForm());

        Assert.assertEquals(alertMessage, authenticationPage.getAlertCreateAccountForm());
    }
}
