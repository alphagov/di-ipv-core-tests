package gov.di_ipv_core.step_definitions;

import gov.di_ipv_core.pages.*;
import gov.di_ipv_core.utilities.BrowserUtils;
import gov.di_ipv_core.utilities.ConfigurationReader;
import gov.di_ipv_core.utilities.Driver;
import io.cucumber.java.en.And;
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

    @Then("I should get five options")
    public void i_should_get_five_options() {
        Assert.assertTrue(new IpvCoreFrontPage().UkPassport.isDisplayed());
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

    @Given("I should see validity score {} in the JSON payload")
    public void i_should_see_validity_data_in_json_payload(String validityScore) {
        String payload = new  DiIpvCoreFrontPage().VerifiableCredentialJSONPayload.getText();
        System.out.println("payload = " + payload);
        Boolean visibilityOfvalidityScore = payload.contains(validityScore);
        System.out.println("visibilityOfvalidityScore = " + visibilityOfvalidityScore);
        Assert.assertTrue(visibilityOfvalidityScore);
    }

    @Given("I should see JSON payload displayed")
    public void i_should_see_my_name_in_json_payload() {
        Assert.assertTrue(new DiIpvCoreFrontPage().Verifiablejson.isDisplayed());
    }
    @When("I click on ukPassport\\(Stub)")
    public void iClickOnUkPassportStub() {
        new IpvCoreFrontPage().UkPassport.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @And("I should see Strength score {} in the JSON payload")
    public void iShouldSeeStrengthScoreInTheJSONPayload(String strengthScore) {
        String payload = new DiIpvCoreFrontPage().VerifiableCredentialJSONPayload.getText();
        System.out.println("payload = " + payload);
        Boolean visibilityOfstrenghtScore = payload.contains(strengthScore);
        System.out.println("visibilityOfstrenghtScore = " + visibilityOfstrenghtScore);
        Assert.assertTrue(visibilityOfstrenghtScore);
    }

}
