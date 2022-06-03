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
import pages.CheckOutPage;
import pages.ShoppingCartPage;
import utility.LoginSteps;
import utility.NavigateToProduct;

public class D12_CreateOrder {

    WebDriver driver = null;

    @Given("user open browser to create order")
    public void userOpenBrowser() {
        //setting up chrome driver
        String chromeDriverPath = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        driver = new ChromeDriver();

        //maximize browser window
        driver.manage().window().maximize();
    }

    @And("user navigate to website to create order")
    public void userNavigateToWebsite() {
        //navigate to the website
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @And("user login to create order")
    public void userLogin() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(driver, "automation2@testing.com", "P@ssw0rd");
    }

    @When("user navigates to product to create order")
    public void userNavigateToAdidasShoes() throws InterruptedException {
        NavigateToProduct navigateToProduct = new NavigateToProduct();
        navigateToProduct.navigateToAdidasShoes(driver);
    }

    @And("user click on Adidas shoes to create order")
    public void userClickOnAdidasShoes() {
        new CategoryPage(driver).adidasShoes.click();
    }

    @And("user choose size to create order")
    public void userChooseSize() {
        new AdidasShoesPage(driver).sizeItem.click();
    }

    @And("user click on add to cart to create order")
    public void userClickOnAddToCart(){
        new AdidasShoesPage(driver).addToCartButton.click();
    }

    @And("user click shopping cart button")
    public void clickShoppingCart(){
        new AdidasShoesPage(driver).shoppingCartButton.click();
    }

    @And("user check the checkbox")
    public void checkBox() {
        new ShoppingCartPage(driver).checkBox.click();
    }

    @And("user click on CHECKOUT")
    public void clickCheckOut(){
        new ShoppingCartPage(driver).checkOutButton.click();
    }

    @And("user fill billing address form")
    public void fillAddressForm(){
        CheckOutPage checkOutPage = new CheckOutPage(driver);
            //1st section
            checkOutPage.egyptOption.click();
            checkOutPage.cityTF.sendKeys("city");
            checkOutPage.addressTF.sendKeys("address");
            checkOutPage.zipCodeTF.sendKeys("123");
            checkOutPage.phoneNumberTF.sendKeys("111111");
            checkOutPage.continueButton1.click();

    }

    @And("user choose Ground")
    public void chooseGroundRadioButton() throws InterruptedException {
        Thread.sleep(1000);

        CheckOutPage checkOutPage = new CheckOutPage(driver);

        //2nd section
        checkOutPage.groundRadioButton.click();
        checkOutPage.continueButton2.click();
    }

    @And("user choose money order")
    public void chooseMoneyOrderRadioButton() throws InterruptedException {
        Thread.sleep(1000);

        CheckOutPage checkOutPage = new CheckOutPage(driver);

        //3rd section
        checkOutPage.moneyOrderRadioButton.click();
        checkOutPage.continueButton3.click();
    }

    @And("user click continue")
    public void clickContinue() throws InterruptedException {
        Thread.sleep(1000);

        new CheckOutPage(driver).continueButton4.click();
    }

    @And("user click confirm")
    public void clickConfirm() throws InterruptedException {
        Thread.sleep(1000);

        new CheckOutPage(driver).confirmButton.click();
    }

    @Then("user should see your order has been successfully processed")
    public void successfulOrderMessage() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(new CheckOutPage(driver).successMessage.isDisplayed());
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
