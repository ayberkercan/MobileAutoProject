package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                 "html:target/cucumber-html-report" // alternatif rapor eklendi
        },


        features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "",
        dryRun = false
)
public class TestRunner {
}

