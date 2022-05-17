package gov.di_ipv_core.step_definitions;

import gov.di_ipv_core.pages.IpvCoreFrontPage;
import gov.di_ipv_core.pages.SupplyDataPage;
import gov.di_ipv_core.utilities.BrowserUtils;
import io.cucumber.java.en.When;

public class KbvStubSmokeSteps {
    String myData;

    @When("I click on Kbv\\(Stub)")
    public void i_click_on_kbv_stub() {
        new IpvCoreFrontPage().KbvStub.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @When("I supply my data in JSON format")
    public void i_supply_my_data_in_json_format() {
        myData = "{\"Hakan\":\"1234\"}";
        new SupplyDataPage().supplyDataInJSONFormatBox.sendKeys(myData);
        BrowserUtils.waitForPageToLoad(10);
    }

    @When("I supply my gpg45 verification value")
    public void i_supply_my_gpg45_verification_value() {
        myData = "2";
        new SupplyDataPage().supplyGpg45VerificationValue.sendKeys(myData);
        BrowserUtils.waitForPageToLoad(10);
    }

    @When("I click on Submit data and generate auth code")
    public void i_click_on_submit_data_and_generate_auth_code() {
        new SupplyDataPage().SubmitDataAndGenerateAuthCode.click();
        BrowserUtils.waitForPageToLoad(10);
    }
}
