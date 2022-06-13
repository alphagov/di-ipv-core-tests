package gov.di_ipv_core.pages;

import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YouHaveSignedInToYourGOVUKAccountPage {
    public YouHaveSignedInToYourGOVUKAccountPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[@class='govuk-button']")
    public WebElement Continue;
}
