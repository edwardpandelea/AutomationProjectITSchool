package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.cartHelper;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class checkoutPage {
    private final WebDriver driver;
    private final cartHelper cartHelper;
    private final By pageStep = By.cssSelector("span[data-test='title']");
    // Checkout: Your Information
    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By zipCodeInput = By.id("postal-code");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");
    private final By continueBtn = By.id("continue");
    private final By cancelBtn = By.id("cancel");
    // Checkout: Overview
    private final By finishBtn = By.id("finish");
    private final By paymentInfo = By.cssSelector("div[data-test='payment-info-value']");
    private final By shippingInformation = By.cssSelector("div[data-test='shipping-info-value']");
    private final By totalPrice = By.cssSelector("div[data-test='subtotal-label']");
    private final By tax = By.cssSelector("div[data-test='tax-label']");
    private final By totalPriceWithTax = By.cssSelector("div[data-test='total-label']");
    // Checkout: Complete
    private final By successIcon = By.cssSelector("img[data-test='pony-express']");
    private final By completeHeader = By.cssSelector("h2[data-test='complete-header']");
    private final By completeText = By.cssSelector("div[data-test='complete-text']");
    private final By backHomeBtn = By.id("back-to-products");

    public checkoutPage(WebDriver driver) {
        this.driver = driver;
        cartHelper = new cartHelper(driver);
    }

    public void completeCheckout(String firstName, String lastName, String zipCode, double totalCartPrice)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // 1st Step of Checkout - Your Information
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageStep));
        assertTrue(driver.findElement(pageStep).getText().toLowerCase().contains("your information"));
        wait.until(ExpectedConditions.elementToBeClickable(firstNameInput));
        driver.findElement(firstNameInput).clear();
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(zipCodeInput).clear();
        driver.findElement(zipCodeInput).sendKeys(zipCode);
        driver.findElement(continueBtn).click();
        // 2nd Step of Checkout - Overview
        assertTrue(driver.findElement(pageStep).getText().toLowerCase().contains("overview"));
        assertTrue(driver.findElement(paymentInfo).getText().toLowerCase().contains("saucecard"));
        assertTrue(driver.findElement(shippingInformation).getText().replace(" ", "").toLowerCase().contains("freeponyexpress"));
        assertEquals(totalCartPrice, Double.parseDouble(driver.findElement(totalPrice).getText().replace("Item total: $", "")), 0.001);
        double totalPriceWithTaxToVerify = totalCartPrice + Double.parseDouble(driver.findElement(tax).getText().replace("Tax: $", ""));
        assertEquals(totalPriceWithTaxToVerify, Double.parseDouble(driver.findElement(totalPriceWithTax).getText().replace("Total: $", "")), 0.001);
        driver.findElement(finishBtn).click();
        // 3rd Step of Checkout - Completed
        assertTrue(driver.findElement(pageStep).getText().toLowerCase().contains("complete"));
        assertTrue(driver.findElement(completeHeader).isDisplayed());
        assertTrue(driver.findElement(completeText).isDisplayed());
        assertTrue(driver.findElement(successIcon).isDisplayed());
        driver.findElement(backHomeBtn).click();
        assertTrue(driver.findElement(By.id("inventory_container")).isDisplayed());
    }

    public void verifyError()
    {
        driver.findElement(continueBtn).click();
        assertTrue(driver.findElement(errorMessage).isDisplayed());
    }





}
