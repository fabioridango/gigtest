package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public TestBase(){
        try {
            prop = new Properties();
            FileInputStream fileConfig = new FileInputStream(System.getProperty("user.dir")+ "/src/test/java/config/"
                    + "config.properties");
            prop.load(fileConfig);

        } catch (IOException e) {
            e.getMessage();
        }
    }


    public  WebDriver initialization(){

        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/src/main/resources/" +
                    "chromedriver");

            driver = new ChromeDriver();
        }
        else if(browserName.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "/src/main/resources/"
                            + "geckodriver");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.navigate().to(prop.getProperty("url"));

        return driver;

    }

    public static void closeBrowser(){
        driver.close();
    }
}