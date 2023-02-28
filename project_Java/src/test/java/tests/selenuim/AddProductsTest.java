package tests.selenuim;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import utils.TestUtils;

public class AddProductsTest extends TestUtils {

    @Test
    public void addItemToTheCart() {
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login("standard_user", "secret_sauce");

        Assert.assertEquals(productPage.pageHeadingMsg(), "PRODUCTS");

        productPage.addItemToTheCart("bolt-t-shirt");
        productPage.addItemToTheCart("onesie");

        Assert.assertEquals(productPage.getItemsInTheCart(), 2);

        productPage.paymentGoTo();
    }
}
