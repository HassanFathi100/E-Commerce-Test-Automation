package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdidasShoesPage {

    WebDriver driver;
    public AdidasShoesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "add-to-cart-button-25")
    public WebElement addToCartButton;

    @FindBy(css = "option[data-attr-value=\"21\"]")
    public WebElement sizeItem;

    @FindBy(css = "p[class=\"content\"] > a[href=\"/cart\"]")
    public WebElement addToCartSuccessfullyAlert;

    @FindBy(css = "p[class=\"content\"] > a[href=\"/wishlist\"]")
    public WebElement addToWishlistSuccessfullyAlert;

    @FindBy(css = "p[class=\"content\"] > a[href=\"/compareproducts\"]")
    public WebElement addToCompareListSuccessfullyAlert;


}
