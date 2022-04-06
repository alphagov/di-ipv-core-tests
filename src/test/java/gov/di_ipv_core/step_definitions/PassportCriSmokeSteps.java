package gov.di_ipv_core.step_definitions;

import gov.di_ipv_core.pages.IpvCoreFrontPage;
import gov.di_ipv_core.pages.PassportPage;
import gov.di_ipv_core.utilities.BrowserUtils;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

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
}

