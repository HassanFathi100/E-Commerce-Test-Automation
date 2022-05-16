package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src\\main\\resources\\features\\01_Register.feature",
                    "src\\main\\resources\\features\\02_Login.feature",
                    "src\\main\\resources\\features\\03_ChangePassword.feature",
                    },
        glue = "testScenarios",
        tags = "@regression"
)

public class TestRunner {

}
