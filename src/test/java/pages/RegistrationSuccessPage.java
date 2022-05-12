package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationSuccessPage {
    WebDriver driver;
    public RegistrationSuccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "div[class=\"result\"]")
    public
    WebElement registrationSuccessMessage;
}
