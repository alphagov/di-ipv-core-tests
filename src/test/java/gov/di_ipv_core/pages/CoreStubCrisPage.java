package gov.di_ipv_core.pages;

import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoreStubCrisPage {
    public CoreStubCrisPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//*[@id=\"main-content\"]/p/a/button")
    public WebElement VisitCredentialIssuersLink;

    @FindBy(xpath = "//input[@value='Build Passport']")
    public WebElement BuildPassportLink;
}
