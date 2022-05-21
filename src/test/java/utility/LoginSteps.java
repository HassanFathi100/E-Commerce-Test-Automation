package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {

    WebDriver driver = null;
    public void login(WebDriver driver, String email, String password){
        this.driver = driver;

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.loginButton.click();

        loginPage.emailTF.sendKeys(email);
        loginPage.passwordTF.sendKeys(password);
        loginPage.loginButton.click();

    }
}
