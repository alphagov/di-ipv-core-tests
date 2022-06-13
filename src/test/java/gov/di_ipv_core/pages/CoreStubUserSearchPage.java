package gov.di_ipv_core.pages;

import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoreStubUserSearchPage {
    public CoreStubUserSearchPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "rowNumber")
    public WebElement rowNumberBox;

    @FindBy(xpath = "//form[@action='/authorize']/div/button")
    public WebElement goToBuildPassportButton;

}
