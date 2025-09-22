package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class homePage {
    private final WebDriver driver;
    private final By sortSelect = By.cssSelector("select[data-test='product-sort-container']");
    private final By cart = By.cssSelector("a[data-test='shopping-cart-link']");
    private final By cartBadge = By.cssSelector("span[data-test='shopping-cart-badge']");
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By allItemsBtn = By.id("inventory_sidebar_link");
    private final By aboutBtn = By.id("about_sidebar_link");
    private final By logoutBtn = By.id("logout_sidebar_link");
    private final By resetAppStateBtn = By.id("reset_sidebar_link");


    public  homePage(WebDriver webDriver)
    {
        this.driver = webDriver;
    }

    public void addSpecificItemToCart(String itemName)
    {
        String convertedItemName = itemName.replace(" ", "-").toLowerCase();
        driver.findElement(By.id("add-to-cart-" + convertedItemName)).click();
    }

    public void verifyItemAddedToCart(int nrOfItems){
        int cartBadgeNrItems = Integer.parseInt(driver.findElement(cartBadge).getText());
        assertEquals(cartBadgeNrItems, nrOfItems);
    }

    public void openCart()
    {
        driver.findElement(cart).click();
    }

    public void logout()
    {
        driver.findElement(menuButton).click();
        driver.findElement(logoutBtn).click();
    }
}
