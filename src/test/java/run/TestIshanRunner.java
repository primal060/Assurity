package run;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


//This is runner file. This file use to run feature files and setting up reports, declare the path to step definition and etc
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/test-report/premium", "json:target/test-report/premium/test-report.json", "junit:target/test-report/premium/test-report.xml"},
        features = {"src/test/resources/Details.feature"},
        tags = {"@TestIshan"},
        glue = {"api.stepDefinition"}
)
public class TestIshanRunner {
}
