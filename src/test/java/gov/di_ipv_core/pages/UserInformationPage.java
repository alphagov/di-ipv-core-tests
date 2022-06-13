package gov.di_ipv_core.pages;

import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserInformationPage {
    public UserInformationPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//*[@id=\"main-content\"]/div[3]/div/dl/div/dd/details/summary/span")
    public WebElement VerifiableCredential;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div[3]/div/dl/div/dd/details/div/pre")
    public WebElement VerifiableCredentialJSONPayload;
}
