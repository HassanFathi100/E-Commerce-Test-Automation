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
    WebElement maleRadioButton;

    @FindBy(id = "gender-female")
    WebElement femaleRadioButton;

    @FindBy(id = "FirstName")
    WebElement firstNameTF;

    @FindBy(id = "LastName")
    WebElement lastNameTF;

    @FindBy(css = "select[name=\"DateOfBirthDay\"] > option[value=\"20\"]")
    WebElement birthDay;

    @FindBy(css = "select[name=\"DateOfBirthMonth\"] > option[value=\"2\"]")
    WebElement birthMonth;

    @FindBy(css = "select[name=\"DateOfBirthYear\"] > option[value=\"2000\"]")
    WebElement birthYear;

    @FindBy(id = "Email")
    WebElement emailTF;

    @FindBy(id = "Company")
    WebElement companyTf;

    @FindBy(id = "Password")
    WebElement passwordTF;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordTF;

    @FindBy(id = "register-button")
    WebElement registerButton;

}
