package org.example.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"D:\\Biomedical\\FWD\\Projects\\ECommerceTestAutomation\\src\\main\\resources\\features\\01_Register.feature",
                    "src\\main\\resources\\features\\02_Login.feature",
                    "src\\main\\resources\\features\\03_ChangePassword.feature",
                    "src\\main\\resources\\features\\04_Search.feature",
                    "src\\main\\resources\\features\\05_ChangeCurrency.feature",
                    "src\\main\\resources\\features\\06_HoverCategories.feature",
                    "src\\main\\resources\\features\\07_FilterColor.feature",
                    "src\\main\\resources\\features\\08_SelectTag.feature",
                    "src\\main\\resources\\features\\09_AddToCart.feature",
                    "src\\main\\resources\\features\\10_AddToWishList.feature",
                    "src\\main\\resources\\features\\11_AddToCompareList.feature",
                    "src\\main\\resources\\features\\12_CreateOrder.feature",
                    },
        glue = "org/example/stepDefinitions",
        tags = "@smoke",
        plugin = {
                "html:target/cucumber.html",
                "json:target/cucumber.json",
        }
)

public class TestRunner {

}
