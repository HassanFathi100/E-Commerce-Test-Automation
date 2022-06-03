package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

    WebDriver driver;
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "billing-address-select")
    public WebElement selectAddressDropDown;

    @FindBy(css = "option[value = \"123\"]")
    public WebElement egyptOption;

    @FindBy(id = "BillingNewAddress_City")
    public WebElement cityTF;

    @FindBy(id = "BillingNewAddress_Address1")
    public WebElement addressTF;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    public WebElement zipCodeTF;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    public WebElement phoneNumberTF;

    @FindBy(css = "button[onclick = \"Billing.save()\"]")
    public WebElement continueButton1;

    @FindBy(css = "input[id=\"shippingoption_0\"]")
    public WebElement groundRadioButton;

    @FindBy(css = "button[onclick = \"ShippingMethod.save()\"]")
    public WebElement continueButton2;

    @FindBy(id = "paymentmethod_0")
    public WebElement moneyOrderRadioButton;

    @FindBy(css = "button[onclick = \"PaymentMethod.save()\"]")
    public WebElement continueButton3;

    @FindBy(css = "button[onclick = \"PaymentInfo.save()\"]")
    public WebElement continueButton4;

    @FindBy(css = "button[onclick = \"ConfirmOrder.save()\"]")
    public WebElement confirmButton;

    @FindBy(css = "div.page-body.checkout-data > div > div.title > strong")
    public WebElement successMessage;
}
