package gov.di_ipv_core.step_definitions;

import gov.di_ipv_core.pages.CoreStubCrisPage;
import gov.di_ipv_core.pages.CoreStubUserSearchPage;
import gov.di_ipv_core.pages.CoreStubVerifiableCredentialsPage;
import gov.di_ipv_core.pages.IpvCoreFrontPage;
import gov.di_ipv_core.pages.PassportPage;
import gov.di_ipv_core.pages.UserInformationPage;
import gov.di_ipv_core.utilities.BrowserUtils;
import gov.di_ipv_core.utilities.ConfigurationReader;
import gov.di_ipv_core.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PassportCriSmokeSteps {

    public static final String EXPIRY_MONTH = "03";
    public static final String EXPIRY_YEAR = "2021";
    private static final String PASSPORT_NUMBER = "824159121";
    public static final String SURNAME = "Watson";
    public static final String FIRST_NAME = "Mary";
    public static final String BIRTH_DAY = "25";
    public static final String BIRTH_MONTH = "02";
    public static final String BIRTH_YEAR = "1932";
    public static final String EXPIRY_DAY = "01";

    @When("I start at the core stub")
    public void startCoreStub() {
        Driver.get().get(ConfigurationReader.getCoreStubUrl());
        BrowserUtils.waitForPageToLoad(10);
    }

    @When("I click on Build Passport")
    public void clickOnBuildPassport() {
        new CoreStubCrisPage().BuildPassportLink.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @When("I enter '{}' in the Row Number box")
    public void enterRowNumber(String rowNumber) {
        new CoreStubUserSearchPage().rowNumberBox.sendKeys(rowNumber);
    }

    @When("I click on Go to Build Passport")
    public void clickOnGoToBuildPassport() {
        new CoreStubUserSearchPage().goToBuildPassportButton.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @Then("I should be on the passport details page")
    public void passportDetailsConfirm() {
        assertTrue(Driver.get().getCurrentUrl().endsWith("/passport/details"));
    }


    @When("I click on ukPassport")
    public void clickOnUkPassport() {
        new IpvCoreFrontPage().UkPassport.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @When("I fill in my details")
    public void fillInPassportDetails() {
        PassportPage passportPage = new PassportPage();

        passportPage.PassportNumber.sendKeys(PASSPORT_NUMBER);
        passportPage.Surname.sendKeys(SURNAME);
        passportPage.FirstName.sendKeys(FIRST_NAME);
        passportPage.birthDay.sendKeys(BIRTH_DAY);
        passportPage.birthMonth.sendKeys(BIRTH_MONTH);
        passportPage.birthYear.sendKeys(BIRTH_YEAR);
        passportPage.PassportExpiryDay.sendKeys(EXPIRY_DAY);
        passportPage.PassportExpiryMonth.sendKeys(EXPIRY_MONTH);
        passportPage.PassportExpiryYear.sendKeys(EXPIRY_YEAR);
    }

    @Then("I should be on the core stub Verifiable Credentials page")
    public void coreStubVcPageConfirm() {
        assertEquals("Verifiable Credentials", new CoreStubVerifiableCredentialsPage().h1.getText());
    }

    @Then("I should see passport data in JSON")
    public void seePassportData() {
        CoreStubVerifiableCredentialsPage coreStubVerifiableCredentialsPage = new CoreStubVerifiableCredentialsPage();
        coreStubVerifiableCredentialsPage.response.click();

        String payload = coreStubVerifiableCredentialsPage.jsonData.getText();
        System.out.println("payload = " + payload);

        Assert.assertTrue(payload.contains(PASSPORT_NUMBER));
        Assert.assertTrue(payload.contains(SURNAME));
        Assert.assertTrue(payload.contains(FIRST_NAME));
        Assert.assertTrue(payload.contains(BIRTH_DAY));
        Assert.assertTrue(payload.contains(BIRTH_MONTH));
        Assert.assertTrue(payload.contains(BIRTH_YEAR));
        Assert.assertTrue(payload.contains(EXPIRY_DAY));
        Assert.assertTrue(payload.contains(EXPIRY_MONTH));
        Assert.assertTrue(payload.contains(EXPIRY_YEAR));
    }
}

