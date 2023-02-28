package tests.selenuim;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.TestUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class UnsuccessfulLogin extends TestUtils {
    @Test(dataProvider = "wrongUsers")

    public void successfulLogin(String userName, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName, password);
    }

    @DataProvider(name = "wrongUsers")
    public Object[][] readUsersFromCvs() {
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/wrongUsers.csv"));
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObj = new Object[csvData.size()][2];
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
