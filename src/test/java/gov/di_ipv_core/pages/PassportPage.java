package gov.di_ipv_core.pages;

import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PassportPage {

    @FindBy(xpath = "//*[@class='govuk-error-summary error-summary']//*[@class='govuk-error-summary__body']//*[@class='govuk-list govuk-error-summary__list']//*[contains(@href,'#passportNumber')]")
    public WebElement InvalidPassportNumberError;

    @FindBy(xpath = "//*[@class='govuk-error-summary error-summary']//*[@class='govuk-error-summary__body']//*[@class='govuk-list govuk-error-summary__list']//*[contains(@href,'#firstName')]")
    public WebElement InvalidPassportFirstName;

    @FindBy(xpath = "//*[@class='govuk-error-summary error-summary']//*[@class='govuk-error-summary__body']//*[@class='govuk-list govuk-error-summary__list']//*[contains(@href,'#surname')]")
    public WebElement InvalidPassportSurname;

    @FindBy(xpath = "//*[@class='govuk-error-summary error-summary']//*[@class='govuk-error-summary__body']//*[@class='govuk-list govuk-error-summary__list']")
    public WebElement InvalidDOB;

    @FindBy(xpath = "//*[@class='govuk-error-summary error-summary']//*[@class='govuk-error-summary__body']//*[@class='govuk-list govuk-error-summary__list']//*[contains(@href,'#expiryDate-day')]")
    public WebElement InvalidExpiryDate;

    @FindBy(xpath = "//*[@class='govuk-notification-banner__content']//h2")
    public WebElement Passportnotfound;

    @FindBy(xpath = "//*[@class='govuk-heading-l']")
    public WebElement Passportnotfoundonretry;

    @FindBy(xpath = "//*[@class='govuk-inset-text']//*[contains(@href,'prove-another-way')]")
    public WebElement proveanotherway;

    @FindBy(xpath = "//*[@class='govuk-radios__item']//*[@id='proveAnotherWayRadio']")
    public WebElement proveidentityanotherway;

    @FindBy(xpath = "//*[@class='govuk-heading-l']")
    public WebElement sorrythereisproblem;

    @FindBy(xpath = "//*[@class='govuk-radios__item']//*[@id='proveAnotherWayRadio-retry']")
    public WebElement enterpassportdetails;

    public PassportPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "passportNumber")
    public WebElement PassportNumber;

    @FindBy(id = "surname")
    public WebElement Surname;

    @FindBy(xpath = "//*[@id=\"firstName\"]")
    public WebElement FirstName;

    @FindBy(id = "middleNames")
    public WebElement MiddleNames;

    @FindBy(id = "dateOfBirth-day")
    public WebElement birthDay;

    @FindBy(id = "dateOfBirth-month")
    public WebElement birthMonth;

    @FindBy(id = "dateOfBirth-year")
    public WebElement birthYear;

    @FindBy(id = "expiryDate-day")
    public WebElement PassportExpiryDay;

    @FindBy(id = "expiryDate-month")
    public WebElement PassportExpiryMonth;

    @FindBy(id = "expiryDate-year")
    public WebElement PassportExpiryYear;

    @FindBy(xpath = "//button[@class='govuk-button button']")
    public WebElement Continue;

}
