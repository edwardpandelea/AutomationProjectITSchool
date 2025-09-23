package tests;

import baseTest.baseTest;
import org.junit.jupiter.api.Test;

public class LoginTests extends baseTest {
    @Test
    public void LoginTest() throws InterruptedException {
        getLoginPage().verifyLogin();
    }

    @Test
    public void NegativeLoginTest() throws InterruptedException {
        getLoginPage().login("asdf", "asdf");
        getLoginPage().verifyErrorMessage();
    }

    @Test
    public void LogoutTest() throws InterruptedException {
        getLoginPage().login("standard_user", "secret_sauce");
        getLoginPage().verifyLogin();
        getHomePage().logout();
    }


}
