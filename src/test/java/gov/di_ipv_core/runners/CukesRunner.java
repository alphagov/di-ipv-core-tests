package gov.di_ipv_core.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports"},
        features = "src/test/resources/features/",
        glue = "gov/di_ipv_core/step_definitions",
        strict = true,
        dryRun = false,
        tags = "@you_have_created_gov.uk_account_test"
)
public class CukesRunner {
}
