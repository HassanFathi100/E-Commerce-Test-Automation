package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {

    WebDriver driver;
    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "div[class=\"page-title\"]")
    public WebElement categoryTitle;

    @FindBy(id = "attribute-option-14")
    public WebElement grayColorButton;

    @FindBy(css = "h2[class=\"product-title\"] > a[href=\"/adidas-consortium-campus-80s-running-shoes\"]")
    public WebElement adidasShoes;

    @FindBy(css = "a[href=\"/apparel-2\"]")
    public WebElement tag;
}
