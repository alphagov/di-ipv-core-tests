package gov.di_ipv_core.pages;

import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateGOVUKAccountOrSignInPage {
    public CreateGOVUKAccountOrSignInPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//button[@id='create-account-link']")
    public WebElement CreateGOVUKAccount;

    @FindBy(xpath = "//button[@id='sign-in-link']")
    public WebElement signIn;
}
