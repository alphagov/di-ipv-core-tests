package gov.di_ipv_core.pages;

import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YouHaveSuccessfullyProvedYourIdentityPage {
    public YouHaveSuccessfullyProvedYourIdentityPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[@role='button']")
    public WebElement Continue;
}
