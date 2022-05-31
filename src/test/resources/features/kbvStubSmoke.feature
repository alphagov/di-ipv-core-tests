@kbv_smoke
Feature: Full journey on Kbv Stub

  Scenario: Test full Kbv Stub UI journey
    Given I am on Orchestrator Stub
    When I click on Debug route
    When I click on Kbv(Stub)
    And I supply my data in JSON format
    And I supply my gpg45 verification value
    And I click on Submit data and generate auth code
    Then I should see GPG45 Score displayed
    When I click on Authorize and Return
    Then I should see User information displayed
    When I click on Verifiable Credentials
    Then I should see Hakan in the JSON payload




