package gov.di_ipv_core.pages;

import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FraudCheckStubPage {
    public FraudCheckStubPage () {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (xpath = "//input[@name='submit']")
    public WebElement JSONPayLoader;

    @FindBy (id ="fraud")
    public WebElement FraudValue;

    @FindBy (xpath = "//input[@name='submit']")
    public WebElement SubmitDataAndGenerateAuthCode;


}
