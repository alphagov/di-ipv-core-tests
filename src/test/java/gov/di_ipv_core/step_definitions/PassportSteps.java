package gov.di_ipv_core.step_definitions;

import gov.di_ipv_core.pages.CoreFrontPage;
import gov.di_ipv_core.pages.DCSCheckIsCompletePage;
import gov.di_ipv_core.pages.PassportPage;
import gov.di_ipv_core.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PassportSteps {

    @When("user clicks UK Passport")
    public void user_clicks_UK_Passport() {
        new CoreFrontPage().UKPassportDCS.click();
        BrowserUtils.waitForVisibility(new PassportPage().PassportNumber, 5);
    }

    @When("user enters {string}, {string}, {string}, {string}, {string}, {string}, {string},{string} and {string}")
    public void user_enters_and(String passportNumber, String surname, String name, String birthDay, String birthMonth, String birthYear, String expiryDay, String expiryMonth, String expiryYear) {
        new PassportPage().PassportNumber.sendKeys(passportNumber);
        new PassportPage().Surname.sendKeys(surname);
        new PassportPage().GivenNames.sendKeys(name);
        new PassportPage().birthDay.sendKeys(birthDay);
        new PassportPage().birthMonth.sendKeys(birthMonth);
        new PassportPage().birthYear.sendKeys(birthYear);
        new PassportPage().PassportExpiryDay.sendKeys(expiryDay);
        new PassportPage().PassportExpiryMonth.sendKeys(expiryMonth);
        new PassportPage().PassportExpiryYear.sendKeys(expiryYear);
    }

    @When("user clicks on continue")
    public void user_clicks_on_continue() {
        new PassportPage().Continue.click();
    }

    @Then("user sees DCS check is complete message")
    public void user_sees_DCS_check_is_complete_message() {
        Assert.assertTrue(new DCSCheckIsCompletePage().DCSCheckIsComplete.isDisplayed());
    }

}
