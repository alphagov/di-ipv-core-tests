package gov.di_ipv_core.pages;

import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiIpvCoreFrontPage {
    public DiIpvCoreFrontPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//input[@value='Authorize and Return']")
    public WebElement AuthorizeAndReturn;

    @FindBy(xpath = "//*[@class='govuk-summary-list__value']//pre")
    public WebElement VerifiableCredentialJSONPayload;
}


