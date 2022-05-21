package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.SearchResultsPage;
import utility.LoginSteps;

public class Search {

    WebDriver driver = null;

    @Given("user open browser for search")
    public void userOpenBrowser (){
        //setting up chrome driver
        String chromeDriverPath = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        driver = new ChromeDriver();

        //maximize browser window
        driver.manage().window().maximize();
    }

    @And("user navigate to website for search")
    public void userNavigateToWebsite(){
        //navigate to the website
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @And("user login to search")
    public void userLogin(){
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(driver, "automation@testing.com", "new_P@ssw0rd");

    }

    @When("^user types \"(.*)\"$")
    public void userSearch(String searchText){
        new HomePage(driver).searchTF.sendKeys(searchText);
    }

    @And("user press search")
    public void userPressSearchButton(){
        new HomePage(driver).searchButton.click();
    }

    @Then("search page title should be displayed")
    public void titleShownSuccessfully(){
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(searchResultsPage.searchTitle.isDisplayed());
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
