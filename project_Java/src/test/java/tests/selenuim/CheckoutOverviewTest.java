package tests.selenuim;

import org.testng.annotations.Test;
import pages.*;
import utils.TestUtils;

public class CheckoutOverviewTest extends TestUtils{

    @Test
    public void checkOut() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        ProductPage productPage = new ProductPage(driver);
        productPage.addItemToTheCart("onesie");
        productPage.paymentGoTo();
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.checkoutToGo();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.login("Petar", "Ivanov", "h400");
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
    }
}
