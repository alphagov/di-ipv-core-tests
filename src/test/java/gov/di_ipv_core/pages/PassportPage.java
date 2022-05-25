package gov.di_ipv_core.pages;

import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PassportPage {

    public PassportPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="passportNumber")
    public WebElement PassportNumber;

    @FindBy(id="surname")
    public WebElement Surname;

    @FindBy(xpath = "//*[@id=\"givenNames\"]")
    public WebElement FirstName;

    @FindBy(id="middleNames")
    public WebElement MiddleNames;

    @FindBy(id="dateOfBirth-day")
    public WebElement birthDay;

    @FindBy(id="dateOfBirth-month")
    public WebElement birthMonth;

    @FindBy(id="dateOfBirth-year")
    public WebElement birthYear;

    @FindBy(id="expiryDate-day")
    public WebElement PassportExpiryDay;

    @FindBy(id="expiryDate-month")
    public WebElement PassportExpiryMonth;

    @FindBy(id="expiryDate-year")
    public WebElement PassportExpiryYear;

    @FindBy(xpath = "//button[@class='govuk-button button']")
    public WebElement Continue;






}
