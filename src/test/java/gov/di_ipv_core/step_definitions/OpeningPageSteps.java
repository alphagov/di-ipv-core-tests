package gov.di_ipv_core.step_definitions;

import gov.di_ipv_core.pages.OpeningPage;
import gov.di_ipv_core.utilities.BrowserUtils;
import gov.di_ipv_core.utilities.ConfigurationReader;
import gov.di_ipv_core.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class OpeningPageSteps {

    @Given("user is on Prove Your Identity page")
    public void user_is_on_Prove_Your_Identity_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitForPageToLoad(10);

    }

    @When("user clicks on Prove Your Identity button")
    public void user_clicks_on_Prove_Your_Identity_button() {
        OpeningPage openingPage = new OpeningPage();
        openingPage.ProveYourIdentityButton.click();
        BrowserUtils.waitForPageToLoad(2);
    }

    @Then("user is on Credential Issuer page")
    public void user_is_on_Credential_Issuer_page() {
        String expectedUrl = "https://di-ipv-core-front.london.cloudapps.digital/debug";
        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        System.out.println("expectedUrl = " + expectedUrl);
        System.out.println("actualUrl = " + actualUrl);

    }

    @When("user clicks on Open Government Licence hyperlink")
    public void user_clicks_on_Open_Government_Licence_hyperlink() {
        new OpeningPage().OpenGovernmentLicenceHyperlink.click();
        BrowserUtils.waitForPageToLoad(5);   }

    @Then("user is is Open Government Licence page")
    public void user_is_is_Open_Government_Licence_page() {
        String expectedUrl = "https://www.nationalarchives.gov.uk/doc/open-government-licence/version/3/";
        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Given("user is in firefox page")
    public void user_is_in_firefox_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitForPageToLoad(2);
    }

    @When("user chooses PYI")
    public void user_chooses_PYI() {
        new OpeningPage().ProveYourIdentityButton.click();
        BrowserUtils.waitForPageToLoad(1);
    }
    @Then("user is on core page")
    public void user_is_on_core_page() {
        System.out.println("User is on Core page");
    }

}
