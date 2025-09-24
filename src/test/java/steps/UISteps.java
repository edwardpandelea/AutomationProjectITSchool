package steps;

import hooks.hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.cartPage;
import pages.homePage;
import pages.productPage;
import utils.cartHelper;

public class UISteps {
    private static final Logger LOG = LoggerFactory.getLogger(CartSteps.class);

    private WebDriver driver()
    {
        return hooks.getDriver();
    }
    @Given("I am on a product page")
    public void iAmOnAProductPage() {
        new homePage(driver()).clickOnItem("Sauce Labs Backpack");
        new productPage(driver()).verifyProductPage();
    }

    @Then("I can see the title, image, description, add to cart button")
    public void iCanSeeTheTitleImageDescriptionAddToCartButton() {
        new productPage(driver()).verifyPage();
    }

    @Given("I am on the cart page")
    public void iAmOnTheCartPage() {
        new homePage(driver()).openCart();
        new cartPage(driver()).verifyCartPage();
    }


    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
       new homePage(driver()).verifyHomePage();
    }

    @When("I click on the menu button")
    public void iClickOnTheMenuButton() {
        new homePage(driver()).clickOnMenuButton();
    }


    @Then("I can see the quantities, descriptions, prices, titles of the product {string}")
    public void iCanSeeTheQuantitiesDescriptionsPricesTitlesOfTheProduct(String arg0) {
        new cartHelper(driver()).verifyItem(arg0);
    }

    @Then("I can see the menu with the following buttons: All items, About, Logout, Reset App State")
    public void iCanSeeTheMenuWithTheFollowingButtonsAllItemsAboutLogoutResetAppState() {
        new homePage(driver()).verifyMenu();
    }
}
