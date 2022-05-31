package gov.di_ipv_core.step_definitions;

import gov.di_ipv_core.pages.CheckYourDetails;
import gov.di_ipv_core.pages.DiIpvCoreFrontPage;
import gov.di_ipv_core.pages.IpvCoreFrontPage;
import gov.di_ipv_core.pages.OrchestratorStubPage;
import gov.di_ipv_core.pages.PassportPage;
import gov.di_ipv_core.pages.UserInformationPage;
import gov.di_ipv_core.pages.WhatsYourCurrentHomeAddressPage;
import gov.di_ipv_core.utilities.BrowserUtils;
import gov.di_ipv_core.utilities.ConfigurationReader;
import gov.di_ipv_core.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class CommonSmokeSteps {
    public static final String CORE_FRONT_DEBUG_H1 = "di-ipv-core-front";
    String KennethPostcode = "BA2 5AA";

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

    @Then("I should be on `What's your current home address?` page")
    public void i_should_be_on_what_s_your_current_home_address_page() {
        Assert.assertTrue(new WhatsYourCurrentHomeAddressPage().FindAddressButton.isDisplayed());
        BrowserUtils.waitForPageToLoad(10);
    }

    @When("I enter postcode and click `Find address`")
    public void i_enter_postcode_and_click_find_address() {
        new WhatsYourCurrentHomeAddressPage().Postcode.sendKeys(KennethPostcode);
        new WhatsYourCurrentHomeAddressPage().FindAddressButton.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @When("I choose address from dropdown and click `Select address`")
    public void i_choose_address_from_dropdown_and_click_select_address() {
        Select select = new Select(new WhatsYourCurrentHomeAddressPage().SelectAnAddress);
        select.selectByValue("8 HADLEY ROAD, BATH, BA2 5AA");
        new WhatsYourCurrentHomeAddressPage().SelectAddress.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @When("I enter `Year` and click `Continue`")
    public void i_enter_year_and_click_continue() {
        new WhatsYourCurrentHomeAddressPage().Year.sendKeys("2020");
        new WhatsYourCurrentHomeAddressPage().Continue.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @Then("I should be on `Check your details` page")
    public void i_should_be_on_check_your_details_page() {
        Assert.assertTrue(new CheckYourDetails().Continue.isDisplayed());
        BrowserUtils.waitForPageToLoad(10);
    }

    @When("I click `Continue` button on `Check your details` page")
    public void i_click_continue_button_on_check_your_details_page() {
        new CheckYourDetails().Continue.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @Then("I should be on `di-ipv-core-front` page")
    public void i_should_be_on_di_ipv_core_front_page() {
        Assert.assertTrue(new DiIpvCoreFrontPage().AuthorizeAndReturn.isDisplayed());
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
        String payload = new UserInformationPage().VerifiableCredentialJSONPayload.getText();
        System.out.println("payload = " + payload);
        boolean visibilityOfName = payload.contains(name);
        System.out.println("visibilityOfName = " + visibilityOfName);
        Assert.assertTrue(visibilityOfName);
    }
}
