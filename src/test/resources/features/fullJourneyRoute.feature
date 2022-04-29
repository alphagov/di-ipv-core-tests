Feature: Testing `Full journey route` on Orchestrator Stub. Happy path with Mary Watson

  @Full_journey_route
  Scenario: UI and Accessibility tests of `Full journey route`
    Given I am on Orchestrator Stub
    When I click on `Full journey route`
    Then I should be on `You’ve signed in to your GOV.UK account` page
    Then the number of `Critical` or `Severe` or `Serious` issues detected must be zero
    When I click `Continue`
    Then I should be on `Enter your details exactly as they appear on your UK passport` page
    When I enter Mary Watson's details and click Continue
    Then I should be on Address (Stub)
    When I supply data in JSON format and click `Submit data and generate auth code`
    Then I should be on Fraud Check (Stub)
    When I supply data in JSON format, Fraud value 1 and click on `Submit data and generate auth code`
    Then I should be on `Answer security questions` page
    Then the number of `Critical` or `Severe` or `Serious` issues detected must be zero
    When I click `Start`
    Then I should be on Knowledge Based Verification (Stub)
    When I supply data in JSON format, Verification value 1 and click on `Submit data and generate auth code`
    Then I should be on You've successfully proved your identity page
    Then the number of `Critical` or `Severe` or `Serious` issues detected must be zero

