package gov.di_ipv_core.step_definitions;

import gov.di_ipv_core.pages.IpvCoreFrontPage;
import gov.di_ipv_core.pages.OrchestratorStubPage;
import gov.di_ipv_core.pages.PassportPage;
import gov.di_ipv_core.pages.UserInformationPage;
import gov.di_ipv_core.utilities.BrowserUtils;
import gov.di_ipv_core.utilities.ConfigurationReader;
import gov.di_ipv_core.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class CommonSmokeSteps {
    public static final String CORE_FRONT_DEBUG_H1 = "di-ipv-core-front";

    @Given("I am on Orchestrator Stub")
    public void i_am_on_orchestrator_stub() {
        Driver.get().get(ConfigurationReader.getOrchestratorUrl());
        BrowserUtils.waitForPageToLoad(10);
    }

    @When("I click on Debug route")
    public void i_click_on_debug_route() {
        new OrchestratorStubPage().DebugRoute.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @Then("I should get five options")
    public void i_should_get_five_options() {
        Assert.assertTrue(new IpvCoreFrontPage().AddressStub.isDisplayed());
    }

    @When("I click continue")
    public void clickContinue() {
        new PassportPage().Continue.click();
    }

    @When("I should be on the core front debug page")
    public void checkH1() {
        assertEquals(CORE_FRONT_DEBUG_H1, new IpvCoreFrontPage().h1.getText());
    }

    @Then("I should see GPG45 Score displayed")
    public void i_should_see_gpg45_score_displayed() {
        Assert.assertTrue(new IpvCoreFrontPage().CredentialAttributes.isDisplayed());
    }

    @When("I click on Authorize and Return")
    public void i_click_on_authorize_and_return() {
        new IpvCoreFrontPage().AuthorizeAndReturn.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @Then("I should see User information displayed")
    public void i_should_see_user_information_displayed() {
        Assert.assertTrue(new UserInformationPage().VerifiableCredential.isDisplayed());
    }

    @When("I click on Verifiable Credentials")
    public void i_click_on_verifiable_credentials() {
        new UserInformationPage().VerifiableCredential.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @Given("I should see {} in the JSON payload")
    public void i_should_see_my_data_in_json_payload(String name) {
        String payload =new UserInformationPage().VerifiableCredentialJSONPayload.getText();
        System.out.println("payload = " + payload);
        boolean visibilityOfName = payload.contains(name);
        System.out.println("visibilityOfName = " + visibilityOfName);
        Assert.assertTrue(visibilityOfName);
    }
}
