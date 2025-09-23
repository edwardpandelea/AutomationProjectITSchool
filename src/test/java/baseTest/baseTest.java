package baseTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;
import utils.cartHelper;


import java.time.Duration;

public class baseTest {
    protected  WebDriver driver;
    private loginPage loginPage;
    private homePage homePage;
    private productPage productPage;
    private cartPage cartPage;
    private checkoutPage checkoutPage;
    private cartHelper cartHelper;

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

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--incognito");
        driver = new  ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new loginPage(driver);
        homePage = new homePage(driver);
        productPage = new productPage(driver);
        cartPage = new cartPage(driver);
        checkoutPage = new checkoutPage(driver);
        cartHelper = new cartHelper(driver);
        loginPage.login("standard_user", "secret_sauce");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
