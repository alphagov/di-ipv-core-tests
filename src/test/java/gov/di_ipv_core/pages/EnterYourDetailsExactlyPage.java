package gov.di_ipv_core.pages;

import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterYourDetailsExactlyPage {
    public EnterYourDetailsExactlyPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "passportNumber")
    public WebElement PassportNumber;

    @FindBy(id = "surname")
    public WebElement Surname;

    @FindBy(id = "firstName")
    public WebElement Firstname;

    @FindBy(id = "middleNames")
    public WebElement Middlenames;

    @FindBy(id = "dateOfBirth-day")
    public WebElement DayOfBirth;

    @FindBy(id = "dateOfBirth-month")
    public WebElement MonthOfBirth;

    @FindBy(id = "dateOfBirth-year")
    public WebElement YearOfBirth;

    @FindBy(id = "expiryDate-day")
    public WebElement PassportExpiryDay;

    @FindBy(id = "expiryDate-month")
    public WebElement PassportExpiryMonth;

    @FindBy(id = "expiryDate-year")
    public WebElement PassportExpiryYear;

    @FindBy(xpath = "//button[@class='govuk-button button']")
    public WebElement Continue;


}
