package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {

    @FindBy(id = "first-name")
    WebElement firstNameInput;

    @FindBy(id = "last-name")
    WebElement lastNameInput;

    @FindBy(id = "postal-code")
    WebElement postalCodeInput;

    @FindBy(id = "continue")
    WebElement continueBtn;

    @FindBy(xpath = "//span[@class = 'title']")
    WebElement checkoutCartMsg;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CheckoutOverviewPage login(String userFirstName, String userLastName, String postalCode)
    {
        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys(userFirstName);

        lastNameInput.click();
        lastNameInput.clear();
        lastNameInput.sendKeys(userLastName);

        postalCodeInput.click();
        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);

        continueBtn.click();

        return new CheckoutOverviewPage(driver);
    }

    public String checkoutMsg() {
        return (checkoutCartMsg.getText());
    }
}
