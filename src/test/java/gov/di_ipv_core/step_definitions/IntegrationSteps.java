package gov.di_ipv_core.step_definitions;

import gov.di_ipv_core.pages.*;
import gov.di_ipv_core.utilities.BrowserUtils;
import gov.di_ipv_core.utilities.ConfigurationReader;
import gov.di_ipv_core.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.retry.backoff.BackoffStrategy;
import software.amazon.awssdk.core.waiters.WaiterOverrideConfiguration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;


public class IntegrationSteps {

    String KennethName = "KENNETH";
    String KennethSurname = "DECERQUEIRA";
    String KennethBirthDay = "07";
    String KennethBirthMonth = "11";
    String KennethBirthYear = "1964";
    String KennethPassportExpiryDay = "01";
    String KennethPassportExpiryMonth = "01";
    String KennethPassportExpiryYear = "2030";
    String KennethPostcode = "BA2 5AA";
    String KennethFullAddress = "8 HADLEY ROAD, BATH, BA2 5AA";
    //Address: 8 Hadley Road, Bath,

    final String KENNETH_PASSPORT_NUMBER = "321654987";
    final String BUCKET_NAME = "staging-smoke-test-sms-codes";
    final String OBJECT_NAME = "+447700900222";
    S3Client s3Client = S3Client.builder().region(Region.EU_WEST_2).build();


    @Given("the user on `Sample Service - Staging` page")
    public void the_user_on_sample_service_staging_page() {
        Driver.get().get(ConfigurationReader.getSampleServiceStagingUrl());
        BrowserUtils.waitForPageToLoad(10);
    }

    @Given("the user has 2FA enabled as well as P2 Level of confidence and claims ticked")
    public void the_user_has_2fa_enabled_as_well_as_p2_level_of_confidence_and_claims_ticked() {
        new SampleServiceStagingPage().P2.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @When("the user clicks on `Continue`")
    public void the_user_clicks_on_continue() {
        new SampleServiceStagingPage().Continue.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @Then("the new user is directed to the `Prove your identity with a GOVUK account page`")
    public void the_new_user_is_directed_to_the_prove_your_identity_with_a_govuk_account_page() {
        new ProveYourIdentityWithGOVUKAccount().AcceptCookies.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @When("the new user selects `Continue to sign in or create a GOV.UK account`")
    public void the_new_user_selects_continue_to_sign_in_or_create_a_gov_uk_account() throws IOException, InterruptedException {
        new ProveYourIdentityWithGOVUKAccount().ContinueToSignInOrCreateGOVUKAccount.click();
        new ProveYourIdentityWithGOVUKAccount().Continue.click();
    }

    @When("the user clicks on `sign in`")
    public void the_user_clicks_on_sign_in() {
        new CreateGOVUKAccountOrSignInPage().signIn.click();
    }

    @When("the user enters their email address and click `Continue`")
    public void the_user_enters_their_email_address_and_click_continue() {
        new SignInToYourGOVUKAccount().EmailAddress.sendKeys("simulate-delivered-3@notifications.service.gov.uk");
        new SignInToYourGOVUKAccount().Continue.click();
    }

    @When("the user enters their password")
    public void the_user_enters_their_password() {
        new EnterYourPasswordPage().Password.sendKeys(System.getenv("PASSWORD"));
        new EnterYourPasswordPage().Continue.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @Then("the user enters their six digit code")
    public void the_user_enters_their_six_digit_code() throws Throwable {
        s3Client.waiter().waitUntilObjectExists(
                HeadObjectRequest
                        .builder()
                        .bucket(BUCKET_NAME)
                        .key(OBJECT_NAME)
                        .build(),
                WaiterOverrideConfiguration
                        .builder()
                        .backoffStrategy(BackoffStrategy.defaultStrategy())
                        .maxAttempts(10)
                        .waitTimeout(Duration.of(30, ChronoUnit.SECONDS))
                        .build()).matched();

        ResponseBytes<GetObjectResponse> response = s3Client.getObjectAsBytes(GetObjectRequest
                .builder()
                .bucket(BUCKET_NAME)
                .key(OBJECT_NAME)
                .build());

        String code = response.asUtf8String();
        System.out.println("code = " + code);


        new CheckYourPhonePage().EnterSixDigitSecurityCode.sendKeys(code);
        new CheckYourPhonePage().Continue.click();
    }

    @When("the new user selects `Create a GOV.UK account`")
    public void the_new_user_selects_create_a_gov_uk_account() {
        new CreateGOVUKAccountOrSignInPage().CreateGOVUKAccount.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @When("the new user provides an email address")
    public void the_new_user_provides_an_email_address() {
        new EnterYourEmailAddressPage().EmailAddress.sendKeys("simulate-delivered-3@notifications.service.gov.uk");
        new EnterYourEmailAddressPage().Continue.click();
    }

    @Then("the user should be on `You’ve signed in to your GOV.UK account` page")
    public void the_user_should_be_on_you_ve_signed_in_to_your_gov_uk_account_page() {
        BrowserUtils.waitFor(3);
        Assert.assertTrue(new YouHaveSignedInToYourGOVUKAccountPage().Continue.isDisplayed());
    }

    @When("the user clicks on `Continue` on `You’ve signed in to your GOV.UK account` page")
    public void the_user_clicks_on_continue_on_you_ve_signed_in_to_your_gov_uk_account_page() {
        new YouHaveSignedInToYourGOVUKAccountPage().Continue.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @Then("the user should be on `Enter your details exactly as they appear on your UK passport` page")
    public void the_user_should_be_on_enter_your_details_exactly_as_they_appear_on_your_uk_passport_page() {
        Assert.assertTrue(new EnterYourDetailsExactlyPage().PassportNumber.isDisplayed());
        BrowserUtils.waitFor(3);
    }

    @When("the user enters their passport details and clicks on `Continue`")
    public void the_user_enters_their_passport_details_and_clicks_on_continue() {
        new EnterYourDetailsExactlyPage().PassportNumber.sendKeys(KENNETH_PASSPORT_NUMBER);
        new EnterYourDetailsExactlyPage().Surname.sendKeys(KennethSurname);
        new EnterYourDetailsExactlyPage().Firstname.sendKeys(KennethName);
        new EnterYourDetailsExactlyPage().DayOfBirth.sendKeys(KennethBirthDay);
        new EnterYourDetailsExactlyPage().MonthOfBirth.sendKeys(KennethBirthMonth);
        new EnterYourDetailsExactlyPage().YearOfBirth.sendKeys(KennethBirthYear);
        new EnterYourDetailsExactlyPage().PassportExpiryDay.sendKeys(KennethPassportExpiryDay);
        new EnterYourDetailsExactlyPage().PassportExpiryMonth.sendKeys(KennethPassportExpiryMonth);
        new EnterYourDetailsExactlyPage().PassportExpiryYear.sendKeys(KennethPassportExpiryYear);
        BrowserUtils.waitFor(3);
        new EnterYourDetailsExactlyPage().Continue.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @Then("the user should be on `What's your current home address` page")
    public void the_user_should_be_on_what_s_your_current_home_address_page() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(new WhatsYourCurrentHomeAddressPage().Postcode.isDisplayed());
        BrowserUtils.waitFor(2);
    }

    @When("the user enters their postcode and click on `Find address` button")
    public void the_user_enters_their_postcode_and_click_on_find_address_button() {
        new WhatsYourCurrentHomeAddressPage().Postcode.sendKeys(KennethPostcode);
        new WhatsYourCurrentHomeAddressPage().FindAddressButton.click();
        BrowserUtils.waitFor(2);
    }

    @When("the user selects their address from the dropdown menu and click on `Select address` button")
    public void the_user_selects_their_address_from_the_dropdown_menu_and_click_on_select_address_button() {
        Select select = new Select(new WhatsYourCurrentHomeAddressPage().SelectAnAddress);
        select.selectByValue(KennethFullAddress);
        BrowserUtils.waitFor(1);
        new WhatsYourCurrentHomeAddressPage().SelectAddress.click();
        BrowserUtils.waitFor(2);
    }

    @When("the user enters the year that they started living at that address")
    public void the_user_enters_the_year_that_they_started_living_at_that_address() {
        new WhatsYourCurrentHomeAddressPage().Year.sendKeys("2014");
        new WhatsYourCurrentHomeAddressPage().Continue.click();
        BrowserUtils.waitFor(2);
    }

    @Then("the user should be shown their address and the move year on `Check your details` page")
    public void the_user_should_be_shown_their_address_and_the_move_year_on_check_your_details_page() {
        Assert.assertTrue(new CheckYourDetails().Continue.isDisplayed());
        BrowserUtils.waitFor(2);
    }

    @When("the user clicks on `Continue` on `Check your details` page")
    public void the_user_clicks_on_continue_on_check_your_details_page() {
        new CheckYourDetails().Continue.click();
        BrowserUtils.waitFor(2);
    }


}





