package gov.di_ipv_core.step_definitions;

import gov.di_ipv_core.pages.CoreFrontPage;
import gov.di_ipv_core.pages.DCSCheckIsCompletePage;
import gov.di_ipv_core.pages.EnterYourDetailsExactlyPage;
import gov.di_ipv_core.pages.PassportPage;
import gov.di_ipv_core.utilities.BrowserUtils;
import gov.di_ipv_core.utilities.PassportSubject;
import io.cucumber.java.en.Given;
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

    @Then("proper error message for could not find details is displayed")
    public void properErrorMessageForCouldNotFindDetailsIsDisplayed() {
        BrowserUtils.waitForPageToLoad(10);
        Assert.assertTrue(new PassportPage().Passportnotfound.isDisplayed());
    }

    @Given("user enters invalid passport details")
    public void userEntersInvalidPassportDetails() {
        new EnterYourDetailsExactlyPage().PassportNumber.sendKeys("123456789");
        new EnterYourDetailsExactlyPage().Surname.sendKeys("Testlastname");
        new EnterYourDetailsExactlyPage().Firstname.sendKeys("Testfirstname");
        new EnterYourDetailsExactlyPage().DayOfBirth.sendKeys("10");
        new EnterYourDetailsExactlyPage().MonthOfBirth.sendKeys("12");
        new EnterYourDetailsExactlyPage().YearOfBirth.sendKeys("1970");
        new EnterYourDetailsExactlyPage().PassportExpiryDay.sendKeys("01");
        new EnterYourDetailsExactlyPage().PassportExpiryMonth.sendKeys("01");
        new EnterYourDetailsExactlyPage().PassportExpiryYear.sendKeys("2030");
        BrowserUtils.waitFor(3);
        //new EnterYourDetailsExactlyPage().Continue.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @When("user Re-enters data as a {}")
    public void userReEntersDataAsAPassportSubject(PassportSubject passportSubject) {
        new PassportPage().PassportNumber.clear();
        new PassportPage().Surname.clear();
        new PassportPage().FirstName.clear();
        new PassportPage().birthDay.clear();
        new PassportPage().birthMonth.clear();
        new PassportPage().birthYear.clear();
        new PassportPage().PassportExpiryDay.clear();
        new PassportPage().PassportExpiryMonth.clear();
        new PassportPage().PassportExpiryYear.clear();
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

    @Then("proper error message for could not find details on retry is displayed")
    public void properErrorMessageForCouldNotFindDetailsOnRetryIsDisplayed() {
        BrowserUtils.waitForPageToLoad(10);
        Assert.assertTrue(new PassportPage().Passportnotfoundonretry.isDisplayed());
    }

    @Given("User click on ‘prove your identity another way' Link")
    public void userClickOnProveYourIdentityAnotherWayLink() {
        new PassportPage().proveanotherway.click();
    }

    @When("user click on Prove your identity another way radio button")
    public void clickOnProveYourIdentityAnotherWayRadioButton() {
        new PassportPage().proveidentityanotherway.click();
        new PassportPage().Continue.click();
    }

    @Then("user should be redirected to Sorry there is a problem with the service")
    public void shouldBeRedirectedToSorryThereIsAProblemWithTheService() {
        BrowserUtils.waitForPageToLoad(10);
        Assert.assertTrue(new PassportPage().sorrythereisproblem.isDisplayed());
    }

    @When("user click on Enter passport details to prove identity radio button")
    public void userClickOnEnterPassportDetailsToProveIdentity() {
        new PassportPage().enterpassportdetails.click();
        new PassportPage().Continue.click();
    }

    @Then("User should be redirected back to passport page")
    public void userShouldBeRedirectedBackToPassportPage() {
        Assert.assertTrue(new EnterYourDetailsExactlyPage().PassportNumber.isDisplayed());
    }
}
