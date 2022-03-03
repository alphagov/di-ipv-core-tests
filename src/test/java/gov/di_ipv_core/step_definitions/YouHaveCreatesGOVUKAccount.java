package gov.di_ipv_core.step_definitions;

import gov.di_ipv_core.pages.EnterYourDetailsExactlyPage;
import gov.di_ipv_core.pages.YouHaveCreatedGOVUKAccountPage;
import gov.di_ipv_core.utilities.BrowserUtils;
import gov.di_ipv_core.utilities.ConfigurationReader;
import gov.di_ipv_core.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.text.BreakIterator;

public class YouHaveCreatesGOVUKAccount {
    @Given("user is on You have created GOV UK Account")
    public void user_is_on_You_have_created_GOV_UK_Account() {
        Driver.get().get(ConfigurationReader.get("You_have_signed_in_to_GOV.UK_account_URL"));
        BrowserUtils.waitForPageToLoad(5);
    }

    @When("user clicks on Continue button")
    public void user_clicks_on_Continue_button() {
        new YouHaveCreatedGOVUKAccountPage().Continue.click();
        BrowserUtils.waitForPageToLoad(5);
    }

    @Then("user is on Enter your details exactly as they appear on your UK passport page")
    public void user_is_on_Enter_your_details_exactly_as_they_appear_on_your_UK_passport_page() {
        Assert.assertTrue(new EnterYourDetailsExactlyPage().PassportNumber.isDisplayed());
    }



}
