package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
        glue = "cucumber",
        tags = "@Xendit-QA-Assessment",
        plugin = {"pretty", "html:target/site/cucumber-report-default.html", "json:target/site/cucumber.json"},
        monochrome = true
)
public class RunCucumberTest {
}
