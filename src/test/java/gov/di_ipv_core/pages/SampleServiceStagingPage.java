package gov.di_ipv_core.pages;

import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SampleServiceStagingPage {
    public SampleServiceStagingPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "loc-P2")
    public WebElement P2;

    @FindBy(xpath = "//button[@id='govuk-signin-button']")
    public WebElement Continue;

}
