package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.cartHelper;
import pages.*;

import java.time.Duration;

public class hooks {
    private static WebDriver driver;
    private loginPage loginPage;
    private homePage homePage;
    private productPage productPage;
    private cartPage cartPage;
    private checkoutPage checkoutPage;
    private cartHelper cartHelper;

    public static WebDriver getDriver() {
        return driver;
    }
    public cartHelper getCartHelper() {
        return cartHelper;
    }

    public cartPage getCartPage() {
        return cartPage;
    }
    public checkoutPage getCheckoutPage() {
        return checkoutPage;
    }
    public productPage getProductPage() {
        return productPage;
    }
    public homePage getHomePage(){
        return homePage;
    }

    public loginPage getLoginPage() {
        return loginPage;
    }

    @Before("@Login")
    public void setUpLogin()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }


    @Before("@needLogin")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new loginPage(driver);
        homePage = new homePage(driver);
        productPage = new productPage(driver);
        cartPage = new cartPage(driver);
        checkoutPage = new checkoutPage(driver);
        cartHelper = new cartHelper(driver);
        loginPage.login("standard_user", "secret_sauce");
    }


    @After("@Login")
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
