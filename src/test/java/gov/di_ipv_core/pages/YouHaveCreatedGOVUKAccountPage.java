package gov.di_ipv_core.pages;

import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YouHaveCreatedGOVUKAccountPage {
    public YouHaveCreatedGOVUKAccountPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "button")
    public WebElement Continue;
}
