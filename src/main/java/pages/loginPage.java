package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class loginPage {
    private final WebDriver driver;
    private final By usernameInput = By.id("user-name");
    private final By passwordInput =  By.id("password");
    private final By loginButton =  By.id("login-button");
    private final By inventoryContainer= By.id("inventory_container");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    public loginPage(WebDriver wd)
    {
        this.driver = wd;
    }

    public void login(String username, String password)
    {
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void verifyLogin(){
        assertTrue(driver.findElement(inventoryContainer).isDisplayed());
    }

    public void verifyErrorMessage()
    {
        assertTrue(driver.findElement(errorMessage).isDisplayed());
        assertTrue(driver.findElement(errorMessage).getText().contains("Username and password do not match"));
    }
}
