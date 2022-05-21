package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.CategoryPage;
import utility.LoginSteps;

public class HoverCategories {

    WebDriver driver = null;
    String subCategoryName;

    @Given("user open browser to change category")
    public void userOpenBrowser() {
        //setting up chrome driver
        String chromeDriverPath = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        driver = new ChromeDriver();

        //maximize browser window
        driver.manage().window().maximize();
    }

    @And("user navigate to website to change category")
    public void userNavigateToWebsite() {
        //navigate to the website
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @And("user login to change category")
    public void userLogin() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(driver, "automation2@testing.com", "P@ssw0rd");
    }

    @When("user hover category and select subcategory")
    public void user_hover_category() throws InterruptedException {

        CategoryPage categoryPage = new CategoryPage(driver);

        Actions action = new Actions(driver);

        // hover on "Computers"
        action.moveToElement(categoryPage.computersButton).perform();

        Thread.sleep(1000);

        // getText() of subCategory before click on it
        subCategoryName = categoryPage.desktopsItemButton.getText().toLowerCase().trim();        // this will change "Desktops " to "desktops"

        // click on "Desktops"
        categoryPage.desktopsItemButton.click();
    }

    @Then("page title should be as the subcategory title")
    public void subCategoryShownSuccessfully(){

        CategoryPage categoryPage = new CategoryPage(driver);

        String categoryTitle = categoryPage.categoryTitle.getText().toLowerCase();
        Assert.assertEquals(categoryTitle, subCategoryName);
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
