package gov.di_ipv_core.pages;

import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoreStubVerifiableCredentialsPage {
    public CoreStubVerifiableCredentialsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/h1")
    public WebElement h1;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/details/summary/span")
    public WebElement response;

    @FindBy(xpath = "//*[@id=\"data\"]")
    public WebElement jsonData;

}
