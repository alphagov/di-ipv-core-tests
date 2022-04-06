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

import java.net.URL;

public class AccessibilitySteps {

    int numberOfIssues;

    private static final URL scriptUrl = AccessibilitySteps.class.getResource("/axe.min.js");

    @Given("I am on the test page")
    public void i_am_on_the_test_page() {
        Driver.get().get(ConfigurationReader.get("testUrl"));
        BrowserUtils.waitForPageToLoad(10);
    }

    @When("I run AXE Accessibility Test")
    public void i_run_axe_accessibility_test() {
        System.out.println("Page in test = " + Driver.get().getTitle());
        JSONObject responseJSON = new AXE.Builder(Driver.get(), scriptUrl).analyze();

        JSONArray violations = responseJSON.getJSONArray("violations");
        numberOfIssues = violations.length();
        System.out.println("numberOfIssues = " + numberOfIssues);
        System.out.println("violations = " + violations);



        AXE.writeResults("AccessibilityTest", responseJSON);
        System.out.println("AXE.report(violations) = " + AXE.report(violations));


    }

    @Then("the number of accessibility issue detected must be zero")
    public void the_number_of_accessibility_issue_detected_must_be_zero() {
        Assert.assertEquals(0, numberOfIssues);
//        System.out.println("tbi");
    }


}
