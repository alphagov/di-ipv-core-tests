@address_smoke
Feature: Full journey on Address Stub

  Scenario: Test full Address Stub UI journey
    Given I am on Orchestrator Stub
    When I click on Debug route
    Then I should get five options
    When I click on Address(Stub)
    And I supply my data in JSON format
    And I click on Submit data and generate auth code
    Then I should see GPG45 Score displayed
    When I click on Authorize and Return
    Then I should see User information displayed
    When I click on Verifiable Credentials
    Then I should see my data in JSON payload




