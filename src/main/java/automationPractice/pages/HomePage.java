package automationPractice.pages;

import automationPractice.Utils.Utils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage

{
    public HomePage() {

        PageFactory.initElements(driver, this);
    }

    public boolean isOnHomePage() {

            return driver.getCurrentUrl().contains("uk.rs-online");
    }

}
