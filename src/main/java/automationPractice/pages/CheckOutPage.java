package automationPractice.pages;

import automationPractice.Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckOutPage extends  BasePage {


    public Utils myUtility=new Utils();
    public HomePage homePage=new HomePage();
    public CheckOutPage()
    {
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = "iframe#_fsCtrlFr._FSFRAME_")
    private WebElement iframeField;
    @FindBy(css = "iframe#lpSS_16988771192")
    private WebElement iframeLoginField;


    @FindBy(css = "#checkoutSecurelyAndPuchBtn")
    private WebElement clickProceedToCheckoutButton;

    @FindBy(css= "#guestCheckoutForm>div>div>span>div>input")
    private WebElement emailTxtField;
    //@FindBy(css = "#guestCheckoutForm>div>input")
    @FindBy(css = ".loginBtn>input[value='Guest checkout']")

    private WebElement guestCheckoutRedButtonField;

    public boolean seeProductInMyCart(String text) {
        Boolean status = false;

        try {

            List<WebElement> Search = driver.findElements(By.cssSelector("a.link2"));
            for (WebElement element : Search) {
                if (element.getText().equalsIgnoreCase(text)) {

                    myUtility.waitForElementVisible(element);
                    status = true;

                }
            }
        }

            catch(Exception e)
            {
                e.printStackTrace();
            }
        return status;

        }




    public void selectCheckOut() {
        myUtility.closePopUp();
        Actions actions = new Actions(driver);
        driver.switchTo().defaultContent();
        actions.moveToElement(clickProceedToCheckoutButton).click().perform();
    }

    public void setEmailAddress(String email) {


            try {
                Thread.sleep(3000);
                myUtility.closePopUp();
                Thread.sleep(3000);
                emailTxtField.sendKeys(email);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    public void selectGuestCheckout() {
        myUtility.closePopUp();

        driver.switchTo().defaultContent();
        if(guestCheckoutRedButtonField.isEnabled()) {

            guestCheckoutRedButtonField.click();
        }

        driver.switchTo().defaultContent();
    }

}