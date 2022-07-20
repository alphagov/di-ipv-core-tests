Feature: Passport Test

  Background:
    Given I am on Orchestrator Stub
    And I click on Debug route
    And I should get five options
    And I click on ukPassport(Stub)
    And I should be on `Enter your details exactly as they appear on your UK passport` page
    And user enters data as a <PassportSubject>
    And user clicks on continue
    Examples:
      |PassportSubject |
      |InvalidPassport |