package gov.di_ipv_core.step_definitions;

import gov.di_ipv_core.pages.CheckYourPhonePage;
import gov.di_ipv_core.pages.CreateGOVUKAccountOrSignInPage;
import gov.di_ipv_core.pages.EnterYourEmailAddressPage;
import gov.di_ipv_core.pages.EnterYourPasswordPage;
import gov.di_ipv_core.pages.ProveYourIdentityWithGOVUKAccount;
import gov.di_ipv_core.pages.SampleServiceStagingPage;
import gov.di_ipv_core.pages.SignInToYourGOVUKAccount;
import gov.di_ipv_core.utilities.BrowserUtils;
import gov.di_ipv_core.utilities.ConfigurationReader;
import gov.di_ipv_core.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
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
    //Kenneth Decerqueira, dob: 23-8-1959, passport expiry: 1-1-2030, passport number: 321654987
    //Address: 8 Hadley Road, Bath, BA2 5AA

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

}





