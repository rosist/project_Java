package tests.selenuim;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PaymentPage;
import pages.ProductPage;
import utils.TestUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class PaymentTest extends TestUtils {
    @Test(dataProvider = "dataPaymentInput")

    public void successfulPayment(String userFirstName, String userLastName, String postalCode) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        ProductPage productPage = new ProductPage(driver);
        productPage.addItemToTheCart("onesie");
        productPage.paymentGoTo();
        PaymentPage paymentPage = new PaymentPage(driver);

        Assert.assertEquals(paymentPage.cartMsg(), "YOUR CART");

        paymentPage.checkoutToGo();
    }

    @DataProvider(name = "dataPaymentInput")
    public Object[][] readUsersFromCvs() {
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/dataPaymentInput.csv"));
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObj = new Object[csvData.size()][3];
            for (int i = 0; i < csvData.size(); i++) {
                csvDataObj[i] = csvData.get(i);
            }
            return csvDataObj;

        } catch (IOException e) {
            System.out.println("Can not find CSV");
            return null;
        } catch (CsvException e) {
            return null;
        }
    }
}
