package gov.di_ipv_core.pages;

import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterYourPasswordPage {
    public EnterYourPasswordPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "password")
    public WebElement Password;

    @FindBy(xpath = "//button[@type='Submit']")
    public WebElement Continue;
}
