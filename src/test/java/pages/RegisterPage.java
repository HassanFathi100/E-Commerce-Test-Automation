package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "gender-male")
    public
    WebElement maleRadioButton;

    @FindBy(id = "gender-female")
    public
    WebElement femaleRadioButton;

    @FindBy(id = "FirstName")
    public
    WebElement firstNameTF;

    @FindBy(id = "LastName")
    public
    WebElement lastNameTF;

    @FindBy(css = "select[name=\"DateOfBirthDay\"] > option[value=\"20\"]")
    public
    WebElement birthDay;

    @FindBy(css = "select[name=\"DateOfBirthMonth\"] > option[value=\"2\"]")
    public
    WebElement birthMonth;

    @FindBy(css = "select[name=\"DateOfBirthYear\"] > option[value=\"2000\"]")
    public
    WebElement birthYear;

    @FindBy(id = "Email")
    public
    WebElement emailTF;

    @FindBy(id = "Company")
    public
    WebElement companyTf;

    @FindBy(id = "Password")
    public
    WebElement passwordTF;

    @FindBy(id = "ConfirmPassword")
    public
    WebElement confirmPasswordTF;

    @FindBy(id = "register-button")
    public
    WebElement registerButton;

}