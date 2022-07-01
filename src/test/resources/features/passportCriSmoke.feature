Feature: Full journey with UK Passport CRI

  @passportSmokeBuild
  Scenario: Successful journey from core stub
    Given I start at the core stub
    And I click on Build Passport
    And I enter '3' in the Row Number box
    And I click on Go to Build Passport
    Then I should be on the passport details page
    When I fill in my details
    And I click continue
    Then I should be on the core stub Verifiable Credentials page
    And I should see passport data in JSON

  @passportSmokeStaging
  Scenario: Successful journey from core
    Given I am on Orchestrator Stub
    When I click on Debug route
    When I click on ukPassport
    And I fill in my details
    And I click continue
    Then I should be on the core front debug page
    And I should see GPG45 Score displayed
    When I click on Authorize and Return
    Then I should see User information displayed
    When I click on Verifiable Credentials
    Then I should see Mary in the JSON payload
