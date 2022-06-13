package gov.di_ipv_core.pages;

import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WhatsYourCurrentHomeAddressPage {
    public WhatsYourCurrentHomeAddressPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "addressSearch")
    public WebElement Postcode;

    @FindBy(xpath = "//button[@class='govuk-button button']")
    public WebElement FindAddressButton;

    @FindBy(id = "addressResults")
    public WebElement FindAddress;

    @FindBy(id = "addressResults")
    public WebElement SelectAnAddress;

    @FindBy(xpath = "//button[@class='govuk-button button']")
    public WebElement SelectAddress;

    @FindBy(id = "addressYearFrom")
    public WebElement Year;

    @FindBy(xpath = "//button[@class='govuk-button button']")
    public WebElement Continue;

}
