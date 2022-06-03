package org.example.utility;

import org.openqa.selenium.WebDriver;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;

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
