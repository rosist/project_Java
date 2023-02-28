package tests.selenuim;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.PaymentPage;
import pages.ProductPage;
import utils.TestUtils;

public class CheckOutTest extends TestUtils {

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

        Assert.assertEquals(checkoutPage.checkoutMsg(), "CHECKOUT: YOUR INFORMATION");

        checkoutPage.login("Petar", "Ivanov", "h400");
    }
}
