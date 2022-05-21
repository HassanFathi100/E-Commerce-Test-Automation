package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import utility.LoginSteps;

public class ChangeCurrency {
    WebDriver driver = null;

    @Given("user open browser for changing currency")
    public void userOpenBrowser(){
        //setting up chrome driver
        String chromeDriverPath = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        driver = new ChromeDriver();

        //maximize browser window
        driver.manage().window().maximize();
        System.out.println(driver);
    }

    @And("user navigates to website for changing currency")
    public void userNavigateToWebsite(){
        //navigate to the website
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @And("user login to change currency")
    public void userLogin(){
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(driver, "automation@testing.com", "new_P@ssw0rd");
    }

    @And("user choose euro")
    public void changeCurrency(){
        new HomePage(driver).currency_Euro.click();
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
