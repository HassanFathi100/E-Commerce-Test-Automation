package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "Email")
    public
    WebElement emailTF;

    @FindBy(id = "Password")
    public
    WebElement passwordTF;

    @FindBy(css = "div[class=\"buttons\"] > button[type=\"submit\"]")
    public
    WebElement loginButton;
}
