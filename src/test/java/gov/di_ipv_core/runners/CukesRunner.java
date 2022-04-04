package gov.di_ipv_core.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        publish = true,
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports"},
        features = "src/test/resources/features/",
        glue = "gov/di_ipv_core/step_definitions",
        dryRun = false,
        tags = "@address_smoke"


)
public class CukesRunner {
}
