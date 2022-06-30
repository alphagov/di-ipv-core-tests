package gov.di_ipv_core.pages;

import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuestionOnePage {
    public QuestionOnePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//h1[@class='govuk-fieldset__heading']")
    public WebElement QuestionOne;

    @FindBy(id = "Q00001")
    public WebElement Correct1;

    @FindBy(id = "Q00001-Incorrect1")
    public WebElement Incorrect1;

    @FindBy(xpath = "//button[@id='continue']")
    public WebElement Continue;
}
