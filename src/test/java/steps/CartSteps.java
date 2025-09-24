package steps;

import hooks.hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.cartPage;
import pages.checkoutPage;
import pages.homePage;
import utils.cartHelper;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartSteps {
    private static final Logger LOG = LoggerFactory.getLogger(CartSteps.class);
    private int nrItems;
    private WebDriver driver()
    {
        return hooks.getDriver();
    }
    @And("I don't have an product added to cart")
    public void iDonTHaveAnProductAddedToCart() {
        new cartHelper(driver()).verifyEmptyCart();
    }

    @Then("I cannot start the checkout process")
    public void iCannotStartTheCheckoutProcess() {
        new checkoutPage(driver()).verifyError();
    }

    @Then("I am redirected to the home page")
    public void iAmRedirectedToTheHomePage() {
        new homePage(driver()).verifyHomePage();
    }

    @And("I click on the cart button")
    public void iClickOnTheCartButton() {
    new homePage(driver()).openCart();

    }

    @Then("the product is removed from the cart")
    public void theProductIsRemovedFromTheCart() {
        assertTrue(new cartHelper(driver()).getItemNumber() < nrItems);
    }

    @And("I click on the Continue shopping button")
    public void iClickOnTheContinueShoppingButton() {
       new cartPage(driver()).clickContinueShoppingButton();
    }

    @When("I click on the Add to cart button of a product")
    public void iClickOnTheAddToCartButtonOfAProduct() {
        new homePage(driver()).addSpecificItemToCart("Sauce Labs Bike Light");
    }

    @Then("the button changes to Remove and the cart icon changes adding the number of products added in the cart")
    public void theButtonChangesToRemoveAndTheCartIconChangesAddingTheNumberOfProductsAddedInTheCart() {
        new homePage(driver()).verifyRemoveButton();
        new homePage(driver()).verifyItemAddedToCart(1);
    }

    @When("I click on the Add to cart button of the Sauce Labs Bike Light")
    public void iClickOnTheAddToCartButtonOfTheSauceLabsBikeLight() {
        new homePage(driver()).addSpecificItemToCart("Sauce Labs Bike Light");
    }

    @Then("I can see the Sauce Labs Bike Light product in the cart page with the correct details")
    public void iCanSeeTheSauceLabsBikeLightProductInTheCartPageWithTheCorrectDetails() {
        new cartHelper(driver()).verifyItem("Sauce Labs Bike");
    }

    @And("I click on the Remove button of a product")
    public void iClickOnTheRemoveButtonOfAProduct() {
        nrItems = new cartHelper(driver()).getItemNumber();
        new cartHelper(driver()).removeItem("Sauce Labs Bike Light");
    }
}
