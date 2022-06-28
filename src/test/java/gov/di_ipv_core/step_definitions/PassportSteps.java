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
        new PassportPage().FirstName.sendKeys(name);
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
