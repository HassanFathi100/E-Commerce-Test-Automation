package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import pages.ChangePasswordPage;
import pages.HomePage;
import pages.MyAccountPage;
import utility.LoginSteps;

public class ChangePassword {

    WebDriver driver = null;

    @Given("user open browser to reset password")
    public void userOpenBrowser() {
        //setting up chrome driver
        String chromeDriverPath = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        driver = new ChromeDriver();

        //maximize browser window
        driver.manage().window().maximize();
    }

    @And("user navigates to website to reset password")
    public void userNavigateToWebsite() {
        //navigate to the website
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @And("user login to reset password")
    public void userLogin(){
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(driver, "automation2@testing.com", "P@ssw0rd");
    }

    @When("user press my account tab")
    public void userPressMyAccountTab(){

        new HomePage(driver).myAccountButton.click();
    }

    @And("click on change password")
    public void clickChangePassword(){
        new MyAccountPage(driver).changePasswordAnchor.click();
    }

    @And("fill data")
    public void fillNewPassword(){
        ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);

        changePasswordPage.oldPasswordTF.sendKeys("P@ssw0rd");
        changePasswordPage.newPasswordTF.sendKeys("new_P@ssw0rd");
        changePasswordPage.confirmNewPasswordTF.sendKeys("new_P@ssw0rd");
    }

    @And("click change password button")
    public void clickChangePasswordButton(){
        new ChangePasswordPage(driver).changePasswordButton.click();
    }

    @Then("user should see confirmation message")
    public void confirmationMessage() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Thread.sleep(1000);
        ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);
        String actualMessage = changePasswordPage.confirmationMessage.getText();
        String expectedMessage = "Password was changed";
        softAssert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @After
    public void closeBrowser(){
        try{
            driver.quit();
        } catch(NullPointerException e){
            e.printStackTrace();
        }
    }
}
