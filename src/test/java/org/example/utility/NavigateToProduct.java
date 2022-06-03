package org.example.utility;

import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class NavigateToProduct {
    WebDriver driver = null;

    public void navigateToAdidasShoes(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        HomePage homePage = new HomePage(driver);
        Actions action = new Actions(driver);

        action.moveToElement(homePage.apparelButton).perform();

        Thread.sleep(1000);

        homePage.shoesItemsButton.click();

    }
}
