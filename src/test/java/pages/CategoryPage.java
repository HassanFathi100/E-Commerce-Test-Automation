package pages;

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

    @FindBy(css = "ul[class=\"top-menu notmobile\"] a[href=\"/computers\"]")
    public WebElement computersButton;

    @FindBy(css = "ul[class=\"top-menu notmobile\"] a[href=\"/desktops\"]")
    public WebElement desktopsItemButton;

    @FindBy(css = "div[class=\"page-title\"]")
    public WebElement categoryTitle;
}
