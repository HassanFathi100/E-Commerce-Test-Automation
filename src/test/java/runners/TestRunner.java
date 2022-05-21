package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src\\main\\resources\\features\\01_Register.feature",
                    "src\\main\\resources\\features\\02_Login.feature",
                    "src\\main\\resources\\features\\03_ChangePassword.feature",
                    "src\\main\\resources\\features\\04_Search.feature",
                    "src\\main\\resources\\features\\05_ChangeCurrency.feature",
                    "src\\main\\resources\\features\\06_HoverCategories.feature",
                    },
        glue = "stepDefinitions",
        tags = "@smoke"
)

public class TestRunner {

}
