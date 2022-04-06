@passportSmoke
Feature: Full journey with UK Passport CRI

  Scenario: Successful journey
    Given I am on Orchestrator Stub
    When I click on Debug route
    Then I should get five options
    When I click on ukPassport
    And I fill in my details
    And I click continue
    Then I should be on the core front debug page
    And I should see GPG45 Score displayed
    When I click on Authorize and Return
    Then I should see User information displayed
    When I click on Verifiable Credentials
    Then I should see Mary in the JSON payload