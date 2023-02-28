package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BasePage {
    private WebDriver driver;

    @FindBy(name = "checkout")
    WebElement checkoutBtn;

    @FindBy(xpath = ("//span[@class = 'title']"))
    WebElement yourCartMsg;

    public PaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CheckoutPage checkoutToGo() {
        checkoutBtn.click();
        return new CheckoutPage(driver);
    }

    public String cartMsg() {
        return (yourCartMsg.getText());
    }
}
