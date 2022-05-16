package gov.di_ipv_core.pages;

import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SupplyDataPage {
    public SupplyDataPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (id = "jsonPayload")
    public WebElement supplyDataInJSONFormatBox;

    @FindBy (id = "verification")
    public WebElement supplyGpg45VerificationValue;

    @FindBy (xpath = "//input[@name='submit']")
    public WebElement SubmitDataAndGenerateAuthCode;
}
