package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.AdidasShoesPage;
import pages.CategoryPage;
import utility.LoginSteps;
import utility.NavigateToProduct;

public class D09_AddToCart {

    WebDriver driver = null;

    @Given("user open browser to add to cart")
    public void userOpenBrowser() {
        //setting up chrome driver
        String chromeDriverPath = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        driver = new ChromeDriver();

        //maximize browser window
        driver.manage().window().maximize();
    }

    @And("user navigate to website to add to cart")
    public void userNavigateToWebsite() {
        //navigate to the website
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

//    @And("user login to add to cart")
//    public void userLogin() {
//        LoginSteps loginSteps = new LoginSteps();
//        loginSteps.login(driver, "automation2@testing.com", "P@ssw0rd");
//    }

    @When("user navigate to product")
    public void userNavigateToAdidasShoes() throws InterruptedException {
        NavigateToProduct navigateToProduct = new NavigateToProduct();
        navigateToProduct.navigateToAdidasShoes(driver);
    }

    @And("user click on Adidas shoes")
    public void userClickOnAdidasShoes() {
        new CategoryPage(driver).adidasShoes.click();
    }

    @And("user choose size")
    public void userChooseSize() {
        new AdidasShoesPage(driver).sizeItem.click();
    }

    @And("user click on add to cart")
    public void userClickOnAddToCart(){
        new AdidasShoesPage(driver).addToCartButton.click();
    }

    @Then("user should see added to cart successfully")
    public void alertShownSuccessfully() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(new AdidasShoesPage(driver).addToCartSuccessfullyAlert.isDisplayed());
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
