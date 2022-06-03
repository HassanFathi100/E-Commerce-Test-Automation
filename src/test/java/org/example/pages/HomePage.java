package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "ico-register")
    public
    WebElement registerButton;

    @FindBy(className = "ico-login")
    public
    WebElement loginButton;

    @FindBy(className = "ico-account")
    public
    WebElement myAccountButton;

    @FindBy(css = "option[value=\"https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F\"]")
    public WebElement currency_Euro;

    @FindBy(id = "small-searchterms")
    public WebElement searchTF;

    @FindBy(css = "button[class=\"button-1 search-box-button\"]")
    public WebElement searchButton;

    @FindBy(css = "ul[class=\"top-menu notmobile\"] a[href=\"/computers\"]")
    public WebElement computersButton;

    @FindBy(css = "ul[class=\"top-menu notmobile\"] a[href=\"/desktops\"]")
    public WebElement desktopsItemButton;

    @FindBy(css = "ul[class=\"top-menu notmobile\"] a[href=\"/apparel\"]")
    public WebElement apparelButton;

    @FindBy(css = "ul[class=\"top-menu notmobile\"] a[href=\"/shoes\"]")
    public WebElement shoesItemsButton;
}
