package pages;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationPage extends TestBase{

    @FindBy(id = "email")
    @CacheLookup
    WebElement emailAddress;

    @FindBy(id = "customer_firstname")
    @CacheLookup
    WebElement firstNamePersonal;

    @FindBy(id = "firstname")
    @CacheLookup
    WebElement firstNameAddress;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]")
    @CacheLookup
    WebElement alertAlreadyRegisteredForm;

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    @CacheLookup
    WebElement createAccountButton;

    @FindBy(id = "email_create")
    @CacheLookup
    WebElement emailAddressCreateAccount;

    @FindBy(xpath = "//div[@id='create_account_error']//ol")
    @CacheLookup
    WebElement alertCreateAccountForm;

    @FindBy(id = "customer_lastname")
    @CacheLookup
    WebElement lastNamePersonal;

    @FindBy(id = "lastname")
    @CacheLookup
    WebElement lastNameAddress;

    @FindBy(id = "passwd")
    @CacheLookup
    WebElement password;

    @FindBy(id = "address1")
    @CacheLookup
    WebElement address;

    @FindBy(id = "city")
    @CacheLookup
    WebElement city;

    @FindBy(id = "id_state")
    @CacheLookup
    WebElement state;

    @FindBy(id = "postcode")
    @CacheLookup
    WebElement postCode;

    @FindBy(id = "phone_mobile")
    @CacheLookup
    WebElement mobilePhone;

    @FindBy(id = "submitAccount")
    WebElement registerButton;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    @CacheLookup
    WebElement alertMessage;

    @FindBy(xpath = "//select[@id='id_country']")
    @CacheLookup
    WebElement country;

    @FindBy(xpath = "//input[@id='alias']")
    @CacheLookup
    WebElement addressAlias;


    WebDriver driver;


    public AccountCreationPage(WebDriver driver) {

        this.driver = driver;

        // Initializing the Page Objects
        PageFactory.initElements(driver, this);
    }

    public String getTitle(){

        return driver.getTitle();
    }

    public void enterFirstNamePersonal(String firstNamePers){

        firstNamePersonal.sendKeys(firstNamePers);
    }

    public void enterFirstNameAddress(String firstNameAdd){

        firstNameAddress.sendKeys(firstNameAdd);
    }

    public String getFirstNameAddress(){

        return firstNameAddress.getText();
    }

    public void enterLastNamePersonal(String lastNamePersonalField){

        lastNamePersonal.sendKeys(lastNamePersonalField);
    }

    public void enterLastNameAddress(String lastNameAddField){

        lastNameAddress.sendKeys(lastNameAddField);
    }

    public void enterPassword(String passwField){

        password.sendKeys(passwField);
    }

    public void enterAddress(String addresField){

        address.sendKeys(addresField);
    }

    public void enterCity(String cityField){

        city.sendKeys(cityField);
    }

    public void selectState(String stateToSelect){

        Select stateSelected = new Select(state);
        stateSelected.selectByVisibleText(stateToSelect);
    }

    public void selectCountry(String countryToSelect){

        Select countrySelected = new Select(country);
        countrySelected.selectByVisibleText(countryToSelect);
    }

    public void enterMobilePhone(String mobileField){

        mobilePhone.sendKeys(mobileField);
    }

    public void enterPostCode(String postCodeField){

        postCode.sendKeys(postCodeField);
    }

    public void clickOnRegisterButton(){

        registerButton.click();
    }

    public String getAlertMessage(){

        return alertMessage.getText();

    }

    public void clearEmail(){

        emailAddress.clear();

    }

    public void clearAddressAlias(){

        addressAlias.clear();

    }

    public void enterEmail(String email){

        emailAddress.sendKeys(email);

    }

    public void enterAddressAlias(String addAlias){

        addressAlias.sendKeys(addAlias);

    }

}
