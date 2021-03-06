package gov.di_ipv_core.pages;

import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FraudCheckStubPage {
    public FraudCheckStubPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "jsonPayload")
    public WebElement JSONPayLoader;

    @FindBy(id = "fraud")
    public WebElement FraudValue;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement SubmitDataAndGenerateAuthCode;

    @FindBy (id = "test_data")
    public WebElement SelectCRISubData;

    @FindBy (id = "fraud")
    public WebElement GPG45Fraud;

    @FindBy (id = "ci")
    public WebElement Contraindicators;

    @FindBy (id = "endpoint")
    public WebElement Authorization;

    @FindBy (id = "requested_oauth_error_endpoint_2")
    public WebElement AccessToken;

    @FindBy (id = "requested_oauth_error")
    public WebElement OAuthError;

    @FindBy (id = "requested_oauth_error_description")
    public WebElement OAuthErrorDescription;












}
