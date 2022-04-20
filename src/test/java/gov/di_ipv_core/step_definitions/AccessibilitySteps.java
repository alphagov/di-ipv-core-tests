package gov.di_ipv_core.step_definitions;

import com.deque.axe.AXE;
import gov.di_ipv_core.utilities.BrowserUtils;
import gov.di_ipv_core.utilities.ConfigurationReader;
import gov.di_ipv_core.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import java.io.IOException;
import java.net.URL;

public class AccessibilitySteps {

    int numberOfSeriousAndSevereIssues;

    private static final URL scriptUrl = AccessibilitySteps.class.getResource("/axe.min.js");

    @Given("I am on the test page")
    public void i_am_on_the_test_page() {
        Driver.get().get(ConfigurationReader.get("addressConfirmPage"));
        BrowserUtils.waitForPageToLoad(10);
    }

    @When("I run AXE Accessibility Test")
    public void i_run_axe_accessibility_test() throws IOException {
        System.out.println("Page in test = " + Driver.get().getTitle());
        JSONObject responseJSON = new AXE.Builder(Driver.get(), scriptUrl).analyze();
        System.out.println("responseJSON.toString() = " + responseJSON.toString());

        JSONArray violations = responseJSON.getJSONArray("violations");

        System.out.println("Number of violations = " + violations.length());

        numberOfSeriousAndSevereIssues=0;
        for (int i = 0; i < violations.length(); i++) {
            JSONObject violation = violations.getJSONObject(i);
            if(violation.get("impact").equals("serious") || violation.get("impact").equals("severe")){
                numberOfSeriousAndSevereIssues = numberOfSeriousAndSevereIssues+1;
            }
            System.out.println("Violation " + (i+1) + " = " +violation.get("help"));
            System.out.println("Violation " + (i +1) + " impact = " + violation.get("impact"));
            System.out.println("numberOfSeriousAndSevereIssues = " + numberOfSeriousAndSevereIssues);

        }

    }

    @Then("the number of severe and serious issues detected must be zero")
    public void the_number_of_severe_and_serious_issues_detected_must_be_zero() {
        Assert.assertEquals(0, numberOfSeriousAndSevereIssues);
    }

    @Given("I am on the {string}")
    public void i_am_on_the(String testPage) {
        Driver.get().get(ConfigurationReader.get(testPage));
        BrowserUtils.waitForPageToLoad(10);
    }

}