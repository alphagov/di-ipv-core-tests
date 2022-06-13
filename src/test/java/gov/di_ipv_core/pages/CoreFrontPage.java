package gov.di_ipv_core.pages;

import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoreFrontPage {
    public CoreFrontPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[normalize-space()='KBV (Stub)']")
    public WebElement KBV;

    @FindBy(xpath = "//a[normalize-space()='UK Passport (DCS)']")
    public WebElement UKPassportDCS;

    @FindBy(xpath = "//a[normalize-space()='Fraud (Stub)']")
    public WebElement Fraud;

    @FindBy(xpath = "//a[normalize-space()='Address (Stub)']")
    public WebElement Address;


}
