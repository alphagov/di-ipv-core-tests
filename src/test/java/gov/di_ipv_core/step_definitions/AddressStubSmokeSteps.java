package gov.di_ipv_core.step_definitions;

import gov.di_ipv_core.pages.IpvCoreFrontPage;
import gov.di_ipv_core.pages.OrchestratorStubPage;
import gov.di_ipv_core.pages.SupplyDataPage;
import gov.di_ipv_core.pages.UserInformationPage;
import gov.di_ipv_core.utilities.BrowserUtils;
import gov.di_ipv_core.utilities.ConfigurationReader;
import gov.di_ipv_core.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddressStubSmokeSteps {

    String myData;

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
    @When("I click on Address\\(Stub)")
    public void i_click_on_address_stub() {
        new IpvCoreFrontPage().AddressStub.click();
        BrowserUtils.waitForPageToLoad(10);
    }
    @When("I supply my data in JSON format")
    public void i_supply_my_data_in_json_format() {
        myData = "{\"Hakan\":\"1234\"}";
        new SupplyDataPage().supplyDataInJSONFormatBox.sendKeys(myData);
        BrowserUtils.waitForPageToLoad(10);
    }
    @When("I click on Submit data and generate auth code")
    public void i_click_on_submit_data_and_generate_auth_code() {
        new SupplyDataPage().SubmitDataAndGenerateAuthCode.click();
        BrowserUtils.waitForPageToLoad(10);


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
    @Then("I should see my data in JSON payload")
    public void i_should_see_my_data_in_json_payload() {
        String payload =new UserInformationPage().VerifiableCredentialJSONPayload.getText();
        System.out.println("payload = " + payload);
        Boolean visibilityOfName = payload.contains("Hakan");
        System.out.println("visibilityOfName = " + visibilityOfName);
        Assert.assertTrue(payload.contains("Hakan"));
    }


}
