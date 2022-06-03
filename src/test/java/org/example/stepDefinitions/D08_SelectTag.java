package org.example.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.utility.LoginSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.example.pages.CategoryPage;
import org.example.pages.HomePage;

public class D08_SelectTag {

    WebDriver driver = null;

    String tagName;

    @Given("user open browser to select tag")
    public void userOpenBrowser() {
        //setting up chrome driver
        String chromeDriverPath = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        driver = new ChromeDriver();

        //maximize browser window
        driver.manage().window().maximize();
    }

    @And("user navigate to website to select tag")
    public void userNavigateToWebsite() {
        //navigate to the website
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @And("user login to select tag")
    public void userLogin() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(driver, "automation2@testing.com", "new_P@ssw0rd");
    }

    @When("user select any category")
    public void selectCategory() {
        new HomePage(driver).apparelButton.click();
    }

    @And("user select any tag")
    public void selectTag() {
        CategoryPage categoryPage = new CategoryPage(driver);

        tagName = categoryPage.tag.getText();

        categoryPage.tag.click();
    }

    @Then("page title should contain this tag")
    public void pageTitleContainTagSuccessfully(){
        CategoryPage categoryPage = new CategoryPage(driver);
        Assert.assertTrue(categoryPage.categoryTitle.getText().contains(tagName));
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
