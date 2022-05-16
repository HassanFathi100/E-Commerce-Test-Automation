package testScenarios;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.RegisterPage;
import pages.RegistrationSuccessPage;

public class Registeration {

    WebDriver driver = null;

    @Given("user open browser for registration")
    public void userOpenBrowser(){
        //setting up chrome driver
        String chromeDriverPath = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        driver = new ChromeDriver();

        //maximize browser window
        driver.manage().window().maximize();
    }

    @And("user navigates to website for registration")
    public void navigateToRegistration(){
        //navigate to the website
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @And("user go to registration page")
    public void navigateToRegistrationPage(){
        HomePage homePage = new HomePage(driver);
        homePage.registerButton.click();
    }

    @When("user enters valid data")
    public void enterValidData() {
        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        //click on register
        homePage.registerButton.click();

        //fill out data
        registerPage.maleRadioButton.click();
        registerPage.firstNameTF.sendKeys("Hassan");
        registerPage.lastNameTF.sendKeys("Fathi");
        registerPage.birthDay.click();
        registerPage.birthMonth.click();
        registerPage.birthYear.click();
        registerPage.emailTF.sendKeys("automation@testing.com");
        registerPage.companyTf.sendKeys("automation company");
        registerPage.passwordTF.sendKeys("P@ssw0rd");
        registerPage.confirmPasswordTF.sendKeys("P@ssw0rd");

    }

    @And("press \"Resister\" button")
    public void pressResister() {
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.registerButton.click();
    }

    @Then("user should see successful registration message")
    public void successfulRegistrationMessage(){
        RegistrationSuccessPage registrationSuccessPage = new RegistrationSuccessPage(driver);

        String expectedMessage = "Your registration completed";
        String actualMessage = registrationSuccessPage.registrationSuccessMessage.getText();
        String color = registrationSuccessPage.registrationSuccessMessage.getCssValue("color");

        //begin assertions
        SoftAssert softAssert = new SoftAssert();

        //check if message is displayed correctly
        softAssert.assertTrue(actualMessage.contains(expectedMessage));

        //check if message is displayed with correct color
        softAssert.assertEquals(color, "rgba(76, 177, 124, 1)");
    }

//    @After
//    public void closeBrowser() throws InterruptedException {
//        Thread.sleep(2000);
//        driver.close();
//    }
}
