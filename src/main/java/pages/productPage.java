package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class productPage {
    private final WebDriver driver;
    private final By productName = By.cssSelector("div[data-test='inventory-item-name']");
    private final By productDescription = By.cssSelector("div[data-test='inventory-item-desc']");
    private final By productPrice = By.cssSelector("div[data-test='inventory-item-price']");
    private final By addToCartBtn = By.id("add-to-cart");
    private final By goBackToProductsBtn = By.id("back-to-products");
    private final By productImage = By.className("inventory_details_img");

    public productPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyProduct(String title, Double price)
    {
        assertTrue(driver.findElement(productName).getText().contains(title));
        assertTrue(driver.findElement(productDescription).isDisplayed());
        assertTrue(driver.findElement(productImage).isDisplayed());
        assertEquals(price, (Double.parseDouble(driver.findElement(productPrice).getText())));
    }

    public void addProductToCart()
    {
        driver.findElement(addToCartBtn).click();
    }

    public void goBackToProducts()
    {
        driver.findElement(goBackToProductsBtn).click();
    }



}
