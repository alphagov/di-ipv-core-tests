package gov.di_ipv_core.pages;

import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpeningPage {

    public OpeningPage(){

        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath = "//input[@value='Prove your identity']")
    public WebElement ProveYourIdentityButton;

    @FindBy(xpath = "//a[@class='govuk-footer__link']")
    public WebElement OpenGovernmentLicenceHyperlink;

}
