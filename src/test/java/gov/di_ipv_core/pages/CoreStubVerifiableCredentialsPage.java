package gov.di_ipv_core.pages;

import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoreStubVerifiableCredentialsPage {
    public CoreStubVerifiableCredentialsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//h1")
    public WebElement h1;

    @FindBy (xpath = "//span[@class='govuk-details__summary-text']")
    public WebElement response;

    @FindBy(id = "data")
    public WebElement jsonData;

}
