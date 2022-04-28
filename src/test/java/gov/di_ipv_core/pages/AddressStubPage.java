package gov.di_ipv_core.pages;

import com.github.dockerjava.core.dockerfile.DockerfileStatement;
import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressStubPage {
    public AddressStubPage (){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (id ="jsonPayload")
    public WebElement JSONPayLoader;

    @FindBy (xpath = "//input[@name='submit']")
    public WebElement SubmitDataAndGenerateAuthCode;


}
