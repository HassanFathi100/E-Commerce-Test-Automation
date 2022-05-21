package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage {
    WebDriver driver;
    public ChangePasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "input[id=\"OldPassword\"]")
    public WebElement oldPasswordTF;

    @FindBy(css = "input[id=\"NewPassword\"]")
    public WebElement newPasswordTF;

    @FindBy(css = "input[id=\"ConfirmNewPassword\"]")
    public WebElement confirmNewPasswordTF;

    @FindBy(css = "div[class=\"buttons\"] > button[type=\"submit\"]")
    public WebElement changePasswordButton;

    @FindBy(css = "p[class=\"content\"]")
    public WebElement confirmationMessage;
}
