package gov.di_ipv_core.pages;

import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProveYourIdentityWithGOVUKAccount {
    public ProveYourIdentityWithGOVUKAccount(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(xpath = "//input[@id='chooseWayPyi']")
    public WebElement ContinueToSignInOrCreateGOVUKAccount;

    @FindBy (xpath = "//*[@id=\"cookies-banner-main\"]/div[2]/button[1]")
    public WebElement AcceptCookies;

    @FindBy(id = "cookies-accepted")
    public WebElement HideThisMessage;

    @FindBy(xpath = "//button[@type='Submit']")
    public WebElement Continue;
}
