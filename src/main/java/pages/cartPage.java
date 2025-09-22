package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class cartPage{
    private final WebDriver driver;
    private final By checkoutBtn = By.id("checkout");
    private final By continueShoppingBtn = By.id("continue-shopping");

    public cartPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public void clickCheckoutButton()
    {
        driver.findElement(checkoutBtn).click();
    }

}
