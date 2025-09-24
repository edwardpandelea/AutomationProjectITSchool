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
import pages.homePage;
import pages.loginPage;

public class LoginSteps {
    private static final Logger LOG = LoggerFactory.getLogger(CartSteps.class);
    private WebDriver driver()
    {
        return hooks.getDriver();
    }
    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        new loginPage(driver()).verifyLoginPage();
    }

    @When("I log in with username and password")
    public void iLogInWithUsernameAndPassword() {
        new loginPage(driver()).login("standard_user", "secret_sauce");
    }

    @Then("I should be redirected to the home page")
    public void iShouldBeRedirectedToTheHomePage() {
        new homePage(driver()).verifyHomePage();
    }

    @When("I try to log in with wrong username and password")
    public void iTryToLogInWithWrongUsernameAndPassword() {
        new loginPage(driver()).login("sasdf", "asdf");

    }

    @Then("I should see the error message: {string}")
    public void iShouldSeeTheErrorMessage(String arg0) {
        new loginPage(driver()).login("standard_user", "secret_sauce");
    }

    @Given("I am on the home page already logged in")
    public void iAmOnTheHomePageAlreadyLoggedIn() {
        new homePage(driver()).verifyHomePage();
    }

    @When("I click the menu button")
    public void iClickTheMenuButton() {
        new homePage(driver()).clickOnMenuButton();
    }

    @And("I click the logout button")
    public void iClickTheLogoutButton() {
        new homePage(driver()).logout();
    }

    @Then("I should be redirected to the login page")
    public void iShouldBeRedirectedToTheLoginPage() {
        new loginPage(driver()).verifyLoginPage();
    }
}
