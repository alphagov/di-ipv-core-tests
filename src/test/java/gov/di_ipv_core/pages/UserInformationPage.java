package gov.di_ipv_core.pages;

import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserInformationPage {
    public UserInformationPage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy (xpath = "//span[@class='govuk-details__summary-text']")
    public WebElement VerifiableCredential;

    @FindBy (xpath = "//div[@class='govuk-details__text']//pre")
    public WebElement VerifiableCredentialJSONPayload;
}
