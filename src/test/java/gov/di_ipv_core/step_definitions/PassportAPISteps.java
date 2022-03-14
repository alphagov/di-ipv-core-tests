package gov.di_ipv_core.step_definitions;

import gov.di_ipv_core.POJO.PassportCheckResult;
import gov.di_ipv_core.POJO.CodeRoot;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import org.junit.Assert;

public class PassportAPISteps {

    String value;
    String redirectURI = "https://dev-danw-di-ipv-core-front.london.cloudapps.digital/credential-issuer/callback?id=ukPassport";
    String passportPostUrl ="https://e7jswiyhje.execute-api.eu-west-2.amazonaws.com/dev/passport?redirect_uri=https://dev-danw-di-ipv-core-front.london.cloudapps.digital/credential-issuer/callback?id=ukPassport&client_id=ipv-core&response_type=code&scope=openid";
    String tokenPostUrl ="https://e7jswiyhje.execute-api.eu-west-2.amazonaws.com/dev/token";
    String credentialGetUrl = "https://e7jswiyhje.execute-api.eu-west-2.amazonaws.com/dev/credential";
    String clientId= "ipv-core";
    String redirect_uri = "https://dev-danw-di-ipv-core-front.london.cloudapps.digital/credential-issuer/callback?id=ukPassport";
    String grant_type = "authorization_code";
    String client_id = "ipv-core-stub";
    String accessToken;
    boolean validMessage;
    int validityValue;
    String requestBody = "{\n" +
            "  \"passportNumber\": \"824159121\",\n" +
            "  \"surname\": \"Watson\",\n" +
            "  \"forenames\": [\n" +
            "    \"Mary\"\n" +
            "  ],\n" +
            "  \"dateOfBirth\": \"1932-02-25\",\n" +
            "  \"expiryDate\": \"2021-03-01\"\n" +
            "}";

    @Given("I am an authorised person")
    public void i_am_an_authorised_person() {

        //creating POST request with passport body to generate code

        Response passportResponse= given()
                .contentType(ContentType.JSON)
                .queryParam("redirect_uri", redirectURI).queryParam("client_id",clientId )
                .body(requestBody)
                .when().post(passportPostUrl);

        CodeRoot codeRoot = passportResponse.body().as(CodeRoot.class);
        value = codeRoot.getCode().getValue();


        //creating POST request with code value to generate access_token

        Response tokenResponse = RestAssured
                .given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("code", value)
                .formParam("redirect_uri", redirect_uri)
                .formParam("grant_type", grant_type)
                .formParam("client_id", client_id)
                        .when().post(tokenPostUrl);

        JsonPath tokenPath = tokenResponse.jsonPath();
        accessToken = tokenPath.get("access_token");
    }

    @When("I send a GET request with valid UK passport")
    public void i_send_a_GET_request_with_valid_UK_passport() {

        Response credentialResponse = RestAssured
                .given()
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + accessToken)
                .when().get(credentialGetUrl);

        PassportCheckResult result = credentialResponse.body().as(PassportCheckResult.class);
        validMessage = result.getAttributes().getDcsResponse().isValid();
        validityValue = result.getGpg45Score().getEvidence().getValidity();
    }

    @Then("I should get passport valid message and validity value must be 2")
    public void i_should_get_passport_valid_message_and_validity_value_must_be_2 () {
        Assert.assertTrue(validMessage);
        System.out.println("validMessage = " + validMessage);
        Assert.assertEquals(2,validityValue);
        System.out.println("validityValue = " + validityValue);
    }

}
