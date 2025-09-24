package steps;

import hooks.hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.cartPage;
import pages.checkoutPage;
import pages.homePage;

public class CheckoutSteps {
    private static final Logger LOG = LoggerFactory.getLogger(CheckoutSteps.class);
    private WebDriver driver()
    {
        return hooks.getDriver();
    }
    @Given("I am logged in and I can see the Home page")
    public void iAmLoggedInAndICanSeeTheHomePage() {
        LOG.info("User is logged in");
    }


    @And("I go to cart")
    public void iGoToCart() {
        new homePage(driver()).openCart();
    }

    @And("I click on {string} button")
    public void iClickOnButton(String arg0) {
        if(arg0.equals("cancel"))
        {
            new checkoutPage(driver()).clickCancelButton();
        } else{
            new cartPage(driver()).clickCheckoutButton();
        }
    }

    @And("I enter first name {string}, last name {string} and zip code {string}")
    public void iEnterFirstNameLastNameAndZipCode(String arg0, String arg1, String arg2) {
        new checkoutPage(driver()).checkoutFirstStep(arg0,arg1,arg2);
    }

    @And("I click on the {string} button")
    public void iClickOnTheButton(String arg0) {
        if(arg0.equals("continue"))
        {
            new checkoutPage(driver()).clickContinue();
        }else{
            new checkoutPage(driver()).goBackToProducts();
        }
    }



    @And("I see the checkout complete page with the success messages")
    public void iSeeTheCheckoutCompletePageWithTheSuccessMessages() {
        new checkoutPage(driver()).checkoutThirdStep();
    }

    @Then("I can't continue and get an error message that contans {string}")
    public void iCanTContinueAndGetAnErrorMessageThatContans(String arg0) {
        new checkoutPage(driver()).verifyError();
    }

    @Then("I am redirected to the cart page")
    public void iAmRedirectedToTheCartPage() {
        new cartPage(driver()).verifyCartPage();
    }

    @When("I add an item {string} to cart")
    public void iAddAnItemToCart(String arg0) {
        new homePage(driver()).addSpecificItemToCart(arg0);
    }

    @And("I verify and then I click on {string} button to finalize the process")
    public void iVerifyAndThenIClickOnButtonToFinalizeTheProcess(String arg0) {
        new checkoutPage(driver()).checkoutSecondStep();
        new checkoutPage(driver()).clickFinishButton();
    }
}
