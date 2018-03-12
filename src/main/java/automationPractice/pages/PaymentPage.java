package automationPractice.pages;

import automationPractice.Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BasePage {

    public PaymentPage()
    {
        PageFactory.initElements(driver, this);

    }

    public boolean onPaymentPage()
    {
         return driver.getCurrentUrl().contains("payment");
    }
}
