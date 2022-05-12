import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

public class Register {

    WebDriver driver = null;

    @BeforeTest
    public void openBrowser(){

        //setting up chrome driver
        String chromeDriverPath = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        driver = new ChromeDriver();

        //maximize browser window
        driver.manage().window().maximize();
    }

    @Test
    public void register(){

        //navigate to the website
        driver.navigate().to("https://demo.nopcommerce.com/");

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
        registerPage.emailTF.sendKeys("automaagbh.anjsddsn@testing.com");
        registerPage.companyTf.sendKeys("auatomation company");
        registerPage.passwordTF.sendKeys("P@ssw0rd");
        registerPage.confirmPasswordTF.sendKeys("P@ssw0rd");
        registerPage.registerButton.click();

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



    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
