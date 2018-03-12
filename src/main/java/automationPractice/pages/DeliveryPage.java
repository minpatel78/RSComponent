package automationPractice.pages;

import automationPractice.Utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryPage extends BasePage {
    public Utils myUtility=new Utils();
    public DeliveryPage()
    {
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = ".//*[@id='deliveryCollectionForm:CustomerContactDetailsWidgetAction_title_decorate']/span/select")
    private WebElement titleField;

    @FindBy(xpath = ".//*[@id='deliveryCollectionForm:CustomerContactDetailsWidgetAction_firstName_decorate:CustomerContactDetailsWidgetAction_firstName']")
    private WebElement firstNameTextField;

    @FindBy(xpath =".//*[@id='deliveryCollectionForm:CustomerContactDetailsWidgetAction_surName_decorate:CustomerContactDetailsWidgetAction_surName']")
    private WebElement lastNameTextField;

    @FindBy(xpath= ".//*[@id='deliveryCollectionForm:CustomerContactDetailsWidgetAction_contactNumber_decorate:CustomerContactDetailsWidgetAction_contactNumber']")
    private WebElement contactNumberTextField;
    @FindBy(xpath = ".//*[@id='deliveryCollectionForm:GuestDeliveryAddressWidgetAction_companyNameOne_decorate:GuestDeliveryAddressWidgetAction_companyNameOne']")
    private WebElement companyTextField;
    @FindBy(xpath = ".//*[@id='deliveryCollectionForm:GuestDeliveryAddressWidgetAction_addressLineOne_decorate:GuestDeliveryAddressWidgetAction_addressLineOne']")
    private WebElement addressLine1TextField;
    @FindBy(xpath = ".//*[@id='deliveryCollectionForm:GuestDeliveryAddressWidgetAction_addressLineThree_decorate:GuestDeliveryAddressWidgetAction_addressLineThree']")
    private WebElement townTextField;
    @FindBy(xpath = ".//*[@id='deliveryCollectionForm:GuestDeliveryAddressWidgetAction_postCode_decorate:GuestDeliveryAddressWidgetAction_postCode']")
    private WebElement postCodeTextField;

    @FindBy(css= "#checkoutSecurelyBtn")
    private WebElement submitPayementButtonField;


    public void setPrsonnelData()
    {
        try {
            Thread.sleep(3000);

             myUtility.selectFromList(titleField,"Mr.");
             firstNameTextField.sendKeys(" Minesh");
             lastNameTextField.sendKeys("Patel");
             contactNumberTextField.sendKeys("123");
             companyTextField.sendKeys(" abcd");
             addressLine1TextField.sendKeys(" 28 Lane");
             townTextField.sendKeys("london");
             postCodeTextField.sendKeys("me7 2yn");
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    }

    public void submitPayment() {
        submitPayementButtonField.click();

    }
}
