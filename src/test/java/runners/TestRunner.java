package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\main\\resources\\features\\Register.feature",
        glue = "testScenarios",
        tags = "@regression"
)

public class TestRunner {

}