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
}
