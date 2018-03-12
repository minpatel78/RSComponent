package automationPractice.Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class   Utils extends BrowserFactory{



    WebDriverWait wait = new WebDriverWait(driver,AutomationConstants.TIMEOUT);

    public void closePopUp() {
        try {
            if (driver.findElement(By.cssSelector("#acsMainInvite")).isDisplayed())
            {
                driver.findElement(By.cssSelector(".acsCloseButton")).click();

            }

        } catch (Exception e) {

        }
    }





    public void waitForElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }



    public void waitForElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void selectFromList(WebElement element, String text) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        for (WebElement we : options) {
            if (we.getText().equals(text)) {
                select.selectByVisibleText(text);
            }
        }
    }



    public static void mouseHoverAndClick(WebElement elementToHover, WebElement elementToClick) {
        Actions action = new Actions(driver);
        action.moveToElement(elementToHover).click(elementToClick).build().perform();
    }

    public void scrollDownWebpage(){

        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
    }

    public void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
