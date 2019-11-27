package pages;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage extends TestBase{

    @FindBy(id = "email")
    @CacheLookup
    WebElement emailAddress;

    @FindBy(id = "passwd")
    @CacheLookup
    WebElement password;

    @FindBy(xpath = "//p[@class='submit']//span[1]")
    @CacheLookup
    WebElement signInButton;

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

    WebDriver driver;


    public AuthenticationPage(WebDriver driver) {

        this.driver = driver;

        // Initializing the Page Objects
        PageFactory.initElements(driver, this);
    }

    public String getTitle(){

        return driver.getTitle();
    }


    public void enterEmailAddress(String email){

        emailAddress.sendKeys(email);
    }

    public void enterPassword(String psw){

        password.sendKeys(psw);
    }

    public void clickOnSignIn(){

        signInButton.click();
    }

    public String getAlertAlreadyRegisteredForm(){

        return alertAlreadyRegisteredForm.getText();
    }

    public String getAlertCreateAccountForm(){

        return alertCreateAccountForm.getText();
    }

    public void clickOnCreateAccountButton(){

        createAccountButton.click();
    }

    public void enterEmailAddressCreateAccount(String email){

        emailAddressCreateAccount.sendKeys(email);
    }

}
