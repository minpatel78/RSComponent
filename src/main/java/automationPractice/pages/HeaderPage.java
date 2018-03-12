package automationPractice.pages;

import automationPractice.Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.awt.geom.AreaOp;

import java.util.List;

public class HeaderPage extends  BasePage {
    Utils myUtility=new Utils();

    public HeaderPage()
    {

        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".verticalMenuHeader")
    private WebElement popularCategoryListField;

    public void hoverToMegaNavElements(String category) {

            myUtility.closePopUp();
            List<WebElement> megaNavLists = driver.findElements(By.cssSelector("a.headerContainer"));
            for (WebElement element : megaNavLists) {
                if (element.getText().equalsIgnoreCase(category)) {
                    new Actions(driver).moveToElement(element).perform();
                    break;
                }

            }
        }

    public void hoverToCatNavElements(String category) {
        myUtility.closePopUp();

        List<WebElement> megaNavLists = driver.findElements(By.cssSelector(".rsGARealEstate>a"));
        for (WebElement element : megaNavLists) {

            if (element.getText().equalsIgnoreCase(category)) {
               // myUtility.popUpHandled();
                new Actions(driver).moveToElement(element).perform();
                element.click();
                break;
            }
        }
        }



    public void selectItemsFromNavOptions(String category) {
        myUtility.closePopUp();

            myUtility.waitForElementClickable(driver.findElement(By.linkText(category)));
            driver.findElement(By.linkText(category)).click();
        }


    public void selectBrands(String brands)
    {

        List<WebElement> megaNavLists = driver.findElements(By.cssSelector(".brand-logo>a"));
        for (WebElement element : megaNavLists) {
            if (element.getAttribute("title").equalsIgnoreCase(brands)) {
                new Actions(driver).moveToElement(element).perform();
                element.click();
                break;
            }

        }

    }

    public void selectPopularCategory(String category) {
        List<WebElement> megaNavLists = driver.findElements(By.cssSelector("#galleryPopularCategory>li>a"));
        for (WebElement element : megaNavLists) {
            if (element.getAttribute("title").equalsIgnoreCase(category)) {
                new Actions(driver).moveToElement(element).perform();
                element.click();
                break;
            }

        }

    }
}



