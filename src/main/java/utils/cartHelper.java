package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class cartHelper {
    private final WebDriver driver;

    public cartHelper(WebDriver driver) {
        this.driver = driver;
    }
    private final By item = By.cssSelector("div[data-test='inventory-item']");
    private final By itemQuantity = By.cssSelector("div[data-test='item-quantity']");
    private final By itemNameLink =  By.cssSelector("div[data-test='inventory-item-name']");
    private final By itemDescription =  By.cssSelector("div[data-test='inventory-item-desc']");
    private final By itemPrice =  By.cssSelector("div[data-test='inventory-item-price']");


    public void removeItem(String name)
    {
        driver.findElement(By.id("remove-" + name.replace(" ", "-").toLowerCase())).click();
    }

    public void verifyItemQuantity(int expectedQuantity, int index)
    {
        assertEquals(expectedQuantity, Integer.parseInt(driver.findElements(itemQuantity).get(index).getText()));
    }

    public String getItemName(int index)
    {
        return driver.findElements(itemNameLink).get(index).getText();
    }

    public int getItemNumber()
    {
        return driver.findElements(item).size();
    }

    public double getItemPrice(int index)
    {
        return Double.parseDouble(driver.findElements(itemPrice).get(index).getText().replace("$", ""));
    }

    public double getTotalPrice()
    {
        double sum = 0;
        List<WebElement> items = driver.findElements(itemPrice);
        for (WebElement item : items)
        {
            sum += Double.parseDouble(item.getText().replace("$", ""));
        }

        return sum;
    }

    public String getItemDescription(int index)
    {
        return driver.findElements(itemDescription).get(index).getText();
    }
}
