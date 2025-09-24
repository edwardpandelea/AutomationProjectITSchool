package steps;

import hooks.hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.homePage;

public class SortSteps {
    private static final Logger LOG = LoggerFactory.getLogger(SortSteps.class);
    private WebDriver driver()
    {
        return hooks.getDriver();
    }
    @And("I select the {string} option from the sort select")
    public void iSelectTheOptionFromTheSortSelect(String arg0) {
        new homePage(driver()).selectSort(arg0);
    }

    @Then("the products are sorted from {string}")
    public void theProductsAreSortedFrom(String arg0) {
        new homePage(driver()).verifySortMenu(arg0);
    }

    @Then("the products are sorted {string}")
    public void theProductsAreSorted(String arg0) {
        new homePage(driver()).verifySortMenu(arg0);
    }
}
