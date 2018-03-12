package automationPractice.pages;

import automationPractice.Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductPage extends  BasePage {


    Utils myUtility = new Utils();


    public ProductPage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn.btn-primary-red.btn-large.btn-add-to-basket")
    private WebElement addProductToBasketField;

    @FindBy(css = ".add-to-basket-container")
    private WebElement addToBasketContainerField;

    @FindBy(css = ".addToCartRTQContainer")
    private WebElement addToCartContainerField;
    @FindBy(css = ".cart-added page-cart-added")
    private WebElement itemaddedcontainerField;
    @FindBy(xpath = "//div[@class='addToCartRTQContainer']//div[@class='cart-added page-cart-added']//button[@type='button' and @class='btn btn-secondary-blue btn-large nav-view-cart']")
    private WebElement viewBasketButtonField;


    public void addItemToCart()

    {
        try {
            myUtility.closePopUp();
            Thread.sleep(3000);
            myUtility.scrollDownWebpage();
            myUtility.mouseHoverAndClick(addToCartContainerField, addProductToBasketField);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    public void viewBasket()

    {
        try
        {
            myUtility.closePopUp();

            myUtility.scrollDownWebpage();
            Thread.sleep(5000);
            Actions actions = new Actions(driver);
            actions.moveToElement(addProductToBasketField);
                Thread.sleep(5000);
                actions.moveToElement(addProductToBasketField);
                actions.moveToElement(viewBasketButtonField).click().perform();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}
