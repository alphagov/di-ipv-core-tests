package gov.di_ipv_core.step_definitions;

import gov.di_ipv_core.pages.CoreFrontPage;
import gov.di_ipv_core.pages.DCSCheckIsCompletePage;
import gov.di_ipv_core.pages.PassportPage;
import gov.di_ipv_core.utilities.BrowserUtils;
import gov.di_ipv_core.utilities.PassportSubject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PassportSteps {

    @When("user clicks UK Passport")
    public void user_clicks_UK_Passport() {
        new CoreFrontPage().UKPassportDCS.click();
        BrowserUtils.waitForVisibility(new PassportPage().PassportNumber, 5);
    }

    @When("user enters data as a {}")
    public void user_enters_and(PassportSubject passportSubject) {
        new PassportPage().PassportNumber.sendKeys(passportSubject.getpassportNumber());
        new PassportPage().Surname.sendKeys(passportSubject.getsurname());
        new PassportPage().FirstName.sendKeys(passportSubject.getgivenName());
        new PassportPage().birthDay.sendKeys(passportSubject.getbirthDay());
        new PassportPage().birthMonth.sendKeys(passportSubject.getbirthMonth());
        new PassportPage().birthYear.sendKeys(passportSubject.getbirthYear());
        new PassportPage().PassportExpiryDay.sendKeys(passportSubject.getexpiryDay());
        new PassportPage().PassportExpiryMonth.sendKeys(passportSubject.getexpiryMonth());
        new PassportPage().PassportExpiryYear.sendKeys(passportSubject.getexpiryYear());
    }

    @When("user clicks on continue")
    public void user_clicks_on_continue() {
        new PassportPage().Continue.click();
    }

    @Then("user sees DCS check is complete message")
    public void user_sees_DCS_check_is_complete_message() {
        Assert.assertTrue(new DCSCheckIsCompletePage().DCSCheckIsComplete.isDisplayed());
    }

    @Then("proper error message for invalid passport number should be displayed")
    public void properErrorMessageForInvalidPassportNumberShouldBeDisplayed() {
        Assert.assertTrue(new PassportPage().InvalidPassportNumberError.isDisplayed());
    }

    @Then("proper error message for invalid First Name should be displayed")
    public void properErrorMessageForInvalidFirstNameShouldBeDisplayed() {
        Assert.assertTrue(new PassportPage().InvalidPassportFirstName.isDisplayed());
    }

    @Then("proper error message for invalid Surname should be displayed")
    public void properErrorMessageForInvalidSurnameShouldBeDisplayed() {
        Assert.assertTrue(new PassportPage().InvalidPassportSurname.isDisplayed());
    }

    @Then("proper error message for invalid Date of Birth should be displayed")
    public void properErrorMessageForInvalidDateOfBirthShouldBeDisplayed() {
        Assert.assertTrue(new PassportPage().InvalidDOB.isDisplayed());
    }

    @Then("proper error message for invalid Expiry Date should be displayed")
    public void properErrorMessageForInvalidExpiryDateShouldBeDisplayed() {
        Assert.assertTrue(new PassportPage().InvalidExpiryDate.isDisplayed());
    }
}
