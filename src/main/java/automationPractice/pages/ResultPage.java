package automationPractice.pages;

import automationPractice.Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ResultPage extends BasePage {
    public Utils myUtility=new Utils();

    public ResultPage() {

        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".filter")
    private WebElement productPropertyFilterField;

    @FindBy(css = ".popover.right.fade.in>div>div>div>rs-apply-button>button")
    private WebElement applyFilterPopUpButtonField;

    public void submitApplyFilter()
    {
        myUtility.waitForElementClickable(applyFilterPopUpButtonField);
        applyFilterPopUpButtonField.click();
    }

    public void selectProduct(String product) {

        try {
            Thread.sleep(3000);
            myUtility.closePopUp();
            Thread.sleep(3000);
            List<WebElement> elements = driver.findElements(By.cssSelector(".product-name"));
            for (WebElement element : elements) {
              if (element.getText().equalsIgnoreCase(product)) {
                    element.click();
                    break;
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void addProductToBasket(String productname) {
        driver.switchTo().defaultContent();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hoverAndClickMultipleElements(productname,By.cssSelector(".product-name"));

    }

    public void hoverOnProductFilter(String value) {

        try {
            Thread.sleep(3000);
            myUtility.closePopUp();
              myUtility.scrollDownWebpage();
            Thread.sleep(3000);
        List<WebElement> elements = driver.findElements(By.cssSelector(".filter"));
        for (WebElement element : elements) {
            if (element.getText().equalsIgnoreCase(value)) {
                driver.switchTo().defaultContent();
                    element.click();
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }


    public void hoverAndClickMultipleElements(String category,By by){
        List<WebElement> megaNavLists = driver.findElements(by);
        for (WebElement element : megaNavLists) {

            if (element.getText().equalsIgnoreCase(category)) {

                new Actions(driver).moveToElement(element).click().build().perform();
               // myUtility.popUpHandled();
                break;
            }
        }
    }

    public boolean checkAllProductsByChemistryFilter(String chemtype) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> elements = driver.findElements(By.cssSelector("#results-table>tbody>tr>td.otherCol"));
        List<String> allProductRatingList = new ArrayList();
        boolean status=false;
        for (WebElement element : elements) {
            if (element.getText().equalsIgnoreCase(chemtype)) {

                status=true;
                break;
            }
            else
            {
                status=false;
            }
        }

        return  status;
    }
    public boolean checkDescForAllProducts(String category) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> elements = driver.findElements(By.xpath(".//*[@id='results-table']/tbody/tr[1]/td[2]/div[4]/a"));
        List<String> allProductRatingList = new ArrayList();
        boolean status=false;
        for (WebElement element : elements) {

            System.out.println(" element"+element.getText()+" category"+category);

                if(element.getText().equalsIgnoreCase(category))
                {
                    System.out.println(" element"+element.getText()+" category"+category);
                    status=true;
                }
                else{
                    status=false;
                }
            }


        return  status;
    }

    public boolean checkDescForAllProductsByName(String category) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> elements = driver.findElements(By.cssSelector(".product-name"));
        List<String> allProductRatingList = new ArrayList();
        boolean status=false;
        for (WebElement element : elements) {
            if(element.getText().equalsIgnoreCase(category))
            {
                status=true;
            }
            else{
                status=false;
            }
        }


        return  status;
    }

    }

