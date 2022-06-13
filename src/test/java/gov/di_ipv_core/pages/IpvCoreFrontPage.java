package gov.di_ipv_core.pages;

import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IpvCoreFrontPage {

    public IpvCoreFrontPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//h1")
    public WebElement h1;

    @FindBy(xpath = "//a[normalize-space()='KBV (Stub)']")
    public WebElement KbvStub;

    @FindBy(xpath = "//a[normalize-space()='ukPassport']")
    public WebElement UkPassport;

    @FindBy(xpath = "//span[@class='govuk-details__summary-text']")
    public WebElement CredentialAttributes;

    @FindBy(xpath = "//input[@value='Authorize and Return']")
    public WebElement AuthorizeAndReturn;

    @FindBy(xpath = "/html/body/div/main/div/div/dl[3]/div/dd/pre")
    public WebElement GPG45Score;

}
