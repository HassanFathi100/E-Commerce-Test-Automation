package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.CategoryPage;
import pages.HomePage;
import utility.LoginSteps;

public class D07_FilterColor {
    WebDriver driver = null;

    @Given("user open browser to change color")
    public void userOpenBrowser() {
        //setting up chrome driver
        String chromeDriverPath = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        driver = new ChromeDriver();

        //maximize browser window
        driver.manage().window().maximize();
    }

    @And("user navigate to website to change color")
    public void userNavigateToWebsite() {
        //navigate to the website
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @And("user login to change color")
    public void userLogin() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(driver, "automation2@testing.com", "P@ssw0rd");
    }

    @When("user hover and select shoes")
    public void userHoverShoes() throws InterruptedException {

        HomePage homePage = new HomePage(driver);

        Actions action = new Actions(driver);

        // hover on "Computers"
        action.moveToElement(homePage.apparelButton).perform();

        Thread.sleep(1000);

        // click on "Desktops"
        homePage.shoesItemsButton.click();
    }

    @And("user select gray")
    public void selectColor(){
        new CategoryPage(driver).grayColorButton.click();
    }

    @After
    public void closeBrowser(){
        try{
            Thread.sleep(2000);
            driver.quit();
        } catch(NullPointerException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
