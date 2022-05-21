package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.UserHomePage;

public class D02_Login {

    WebDriver driver = null;


    @Given("user open browser for login")
    public void userOpenBrowser(){
        //setting up chrome driver
        String chromeDriverPath = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        driver = new ChromeDriver();

        //maximize browser window
        driver.manage().window().maximize();
    }

    @And("user navigates to website for login")
    public void userNavigateToWebsite(){
        //navigate to the website
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @And("user click on Login button")
    public void clickLoginButton(){
        HomePage homePage = new HomePage(driver);

        //click on login button
        homePage.loginButton.click();
    }

    @When("^user enter \"(.*)\" and \"(.*)\"$")
    public void enterValidData(String email, String password){
        LoginPage loginPage = new LoginPage(driver);

        //fill out credentials
        loginPage.emailTF.sendKeys(email);
        loginPage.passwordTF.sendKeys(password);
    }

    @And("user press Login button")
    public void pressLogin() {
        LoginPage loginPage = new LoginPage(driver);

        //click on login button
        loginPage.loginButton.click();
    }

    @Then("user should be navigated to home page")
    public void navigateToHomePageSuccessfully() {

        SoftAssert softAssert = new SoftAssert();

        String currentURL = driver.getCurrentUrl();

        //check if it navigates to correct path
        softAssert.assertEquals(currentURL, "https://demo.nopcommerce.com/");
    }

    @And("user should see My account tab")
    public void myAccountTabShownSuccessfully() {

        UserHomePage userHomePage = new UserHomePage(driver);

        SoftAssert softAssert = new SoftAssert();

        //check if (My account) button is shown
        softAssert.assertTrue(userHomePage.myAccountTab.isDisplayed());
    }

//    @And("close browser for login")
//    public void closeBrowser() throws InterruptedException {
//        Thread.sleep(2000);
//        driver.quit();
//    }
@After
public void closeBrowser(){
    try{
        driver.quit();
    } catch(NullPointerException e){
        e.printStackTrace();
    }
}
}

