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
import pages.AccountCreationPage;

public class AccountCreationStepDefs {

    public static HomePage homePage;
    public TestBase testBase;
    public AuthenticationPage authenticationPage;
    public AccountCreationPage accountCreationPage;
    public WebDriver driver;

    @Given("^I am on create account page with email address \"([^\"]*)\"$")
    public void iAmOnCreateAccountPageWithEmailAddress(String email) throws Throwable {

        testBase = new TestBase();

        driver = testBase.initialization();

        homePage = new HomePage(driver);

        Assert.assertEquals("My Store", homePage.getTitle());

        homePage.clickOnSinInLink();

        authenticationPage = new AuthenticationPage(driver);

        Assert.assertEquals("Login - My Store", authenticationPage.getTitle());

        accountCreationPage = new AccountCreationPage(driver);

        authenticationPage.enterEmailAddressCreateAccount(email);

        authenticationPage.clickOnCreateAccountButton();

        Assert.assertEquals("Login - My Store", accountCreationPage.getTitle());
    }


    @When("^I enter last name \"([^\"]*)\" in your personal information form$")
    public void iEnterLastNameInYourPersonalInformationForm(String lastName) throws Throwable {

        accountCreationPage.enterLastNamePersonal(lastName);

    }

    @And("^I enter password \"([^\"]*)\" in your personal information form$")
    public void iEnterPasswordInYourPersonalInformationForm(String password) throws Throwable {

        accountCreationPage.enterPassword(password);
    }

    @And("^I enter address \"([^\"]*)\" in your address form$")
    public void iEnterAddressInYourAddressForm(String address) throws Throwable {

        accountCreationPage.enterAddress(address);

    }

    @And("^I enter city \"([^\"]*)\" in your address form$")
    public void iEnterCityInYourAddressForm(String city) throws Throwable {

        accountCreationPage.enterCity(city);

    }

    @And("^I select state \"([^\"]*)\" in your address form$")
    public void iSelectStateInYourAddressForm(String state) throws Throwable {

        accountCreationPage.selectState(state);

    }

    @And("^I enter postcode \"([^\"]*)\" in your address form$")
    public void iEnterPostcodeInYourAddressForm(String postCode) throws Throwable {

        accountCreationPage.enterPostCode(postCode);

    }

    @And("^I enter mobile phone \"([^\"]*)\" in your address form$")
    public void iEnterMobilePhoneInYourAddressForm(String mobilePhone) throws Throwable {

        accountCreationPage.enterMobilePhone(mobilePhone);

    }

    @And("^I click on register button$")
    public void iClickOnRegisterButton() {

        accountCreationPage.clickOnRegisterButton();
        
    }

    @Then("^I should see the error message \"([^\"]*)\"$")
    public void iShouldSeeTheErrorMessage(String alertMessage) throws Throwable {

        if (alertMessage.equals("Country is invalid")){

            Assert.assertEquals("There are 3 errors" + System.lineSeparator() + "id_country is required."
                    + System.lineSeparator() + "Country cannot be loaded with address->id_country" + System.lineSeparator()
                    + alertMessage, accountCreationPage.getAlertMessage());

        }
        else {

            Assert.assertEquals("There is 1 error" + System.lineSeparator() + alertMessage, accountCreationPage.getAlertMessage());

        }


    }

    @When("^I enter first name \"([^\"]*)\" in your personal information form$")
    public void iEnterFirstNameInYourPersonalInformationForm(String firstName) throws Throwable {

        accountCreationPage.enterFirstNamePersonal(firstName);
    }

    @And("^I enter blank email in your personal information form$")
    public void iEnterBlankEmailInYourPersonalInformationForm() {

        accountCreationPage.clearEmail();

    }

    @And("^I select the blank option for country in your address form$")
    public void iSelectTheBlankOptionForCountryInYourAddressForm() {

        accountCreationPage.selectCountry("-");

    }

    @And("^I enter blank address alias in your address form$")
    public void iEnterBlankAddressAliasInYourAddressForm() {

        accountCreationPage.clearAddressAlias();
    }

    @And("^I close browser$")
    public void iCloseBrowser() {

        TestBase.closeBrowser();

    }

    @And("^I enter email \"([^\"]*)\" in your personal information form$")
    public void iEnterEmailInYourPersonalInformationForm(String email) throws Throwable {

        accountCreationPage.clearEmail();

        accountCreationPage.enterEmail(email);

    }

    @Then("^I should see my account page$")
    public void iShouldSeeMyAccountPage() {

        Assert.assertEquals("My account - My Store",accountCreationPage.getTitle());

    }

    @And("^I enter first name \"([^\"]*)\" in your address form$")
    public void iEnterFirstNameInYourAddressForm(String firstName) throws Throwable {

        accountCreationPage.enterFirstNameAddress(firstName);

    }

    @And("^I enter last name \"([^\"]*)\" in your address form$")
    public void iEnterLastNameInYourAddressForm(String lastName) throws Throwable {

        accountCreationPage.enterLastNameAddress(lastName);
    }

    @And("^I enter address alias \"([^\"]*)\" in your address form$")
    public void iEnterAddressAliasInYourAddressForm(String addressAlias) throws Throwable {

        accountCreationPage.clearAddressAlias();

        accountCreationPage.enterAddressAlias(addressAlias);

    }
}

