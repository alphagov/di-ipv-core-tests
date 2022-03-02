Feature: You have created GOV.UK account

  @you_have_created_gov.uk_account_test
  Scenario: Testing You have created GOV.UK account page
    Given user is on You have created GOV UK Account
    When user clicks on Continue button
    Then user is on Enter your details exactly as they appear on your UK passport page
