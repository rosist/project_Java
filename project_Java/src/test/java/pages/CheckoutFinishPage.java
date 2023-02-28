package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutFinishPage extends BasePage {

    @FindBy(className = "pony_express")
    WebElement ponyExpress;

    @FindBy(className = "complete-header")
    WebElement thankyouMsg;

    public CheckoutFinishPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean ponyImage() {
        return (ponyExpress.isDisplayed());
    }

    public boolean getFinishedMsg() {
        return (thankyouMsg.isDisplayed());
    }
}
