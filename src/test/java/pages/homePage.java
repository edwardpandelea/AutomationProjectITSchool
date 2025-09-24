package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.DriverManager;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class homePage {
    private final WebDriver driver;
    private final By sortSelect = By.cssSelector("select[data-test='product-sort-container']");
    private final By cart = By.cssSelector("a[data-test='shopping-cart-link']");
    private final By cartBadge = By.cssSelector("span[data-test='shopping-cart-badge']");
    private final By menuBtn = By.id("react-burger-menu-btn");
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
        assertEquals(nrOfItems, cartBadgeNrItems);
    }

    public void verifyRemoveButton()
    {
        assertTrue(driver.findElement(By.xpath("//button[text()='Remove']")).isDisplayed());
    }

    public void verifyHomePage(){
        assertTrue(driver.findElement(By.id("inventory_container")).isDisplayed());
    }

    public List<String> getAllItemsTitle(){
        List<WebElement> allItems = driver.findElements(By.cssSelector("div[data-test='inventory_item_name']"));
        return allItems.stream().map(WebElement::getText).toList();
    }

    public List<Double> getAllItemsPrice(){
        List<WebElement> allItems = driver.findElements(By.cssSelector("div[data-test='inventory_item_price']"));
        return allItems.stream().map(WebElement::getText).map(s -> s.replace("$","")).map(Double::parseDouble).toList();
    }


    public void verifyMenu()
    {
        assertTrue(driver.findElement(allItemsBtn).isDisplayed());
        assertTrue(driver.findElement(aboutBtn).isDisplayed());
        assertTrue(driver.findElement(logoutBtn).isDisplayed());
        assertTrue(driver.findElement(resetAppStateBtn).isDisplayed());
    }

    public void selectSort(String sortType)
    {
        driver.findElement(sortSelect).click();
        driver.findElement(By.xpath("//option[text()='" + sortType + "']")).click();
    }

    public void verifySortMenu(String sortType)
    {
        if (sortType.contains("A to Z")) {
            List<String> itemsNames = getAllItemsTitle();
            List<String> sortedItemsNames = new ArrayList<>(itemsNames); // copie
            Collections.sort(sortedItemsNames);
            assertEquals(sortedItemsNames, itemsNames);

        } else if (sortType.contains("Z to A")) {
            List<String> itemsNames = getAllItemsTitle();
            List<String> sortedItemsNames = new ArrayList<>(itemsNames); // copie
            sortedItemsNames.sort(Collections.reverseOrder());
            assertEquals(sortedItemsNames, itemsNames);

        } else if (sortType.contains("Low to High")) {
            List<Double> itemsPrices = getAllItemsPrice();
            List<Double> sortedItemsPrices = new ArrayList<>(itemsPrices); // copie
            Collections.sort(sortedItemsPrices);
            assertEquals(sortedItemsPrices, itemsPrices);

        } else {
            List<Double> itemsPrices = getAllItemsPrice();
            List<Double> sortedItemsPrices = new ArrayList<>(itemsPrices); // copie
            sortedItemsPrices.sort(Collections.reverseOrder());
            assertEquals(sortedItemsPrices, itemsPrices);
        }

    }

    public void openCart()
    {
        driver.findElement(cart).click();
    }
    public void clickOnMenuButton()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
        menuButton.click();
    }
    public void clickOnAllItemsButton()
    {
        driver.findElement(allItemsBtn).click();
    }
    public void clickOnAboutButton()
    {
        driver.findElement(aboutBtn).click();
    }

    public void logout()
    {
        clickOnMenuButton();
        driver.findElement(logoutBtn).click();
    }

    public void clickOnItem(String itmName)
    {
        driver.findElement(By.xpath("//div[text()='" + itmName + "']")).click();
    }
}
