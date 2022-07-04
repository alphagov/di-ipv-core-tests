package gov.di_ipv_core.pages;

import gov.di_ipv_core.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuestionTwoPage {
    public QuestionTwoPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//h1[@class='govuk-fieldset__heading']")
    public WebElement QuestionTwo;

    @FindBy(id = "Q00002")
    public WebElement Correct2;

    @FindBy(id = "Q00002-Incorrect2")
    public WebElement Incorrect2;

    @FindBy(id = "continue")
    public WebElement Continue;
}
