import org.junit.jupiter.api.Test;

import java.time.Duration;

public class CheckoutProcess extends baseTest{
    @Test
    public void checkoutProcess(){
        getHomePage().addSpecificItemToCart("Sauce Labs Backpack");
        getHomePage().openCart();
        double totalPrice = getCartHelper().getTotalPrice();
        getCartPage().clickCheckoutButton();
        getCheckoutPage().completeCheckout("edward", "pandelea", "1234", totalPrice);
    }
}
