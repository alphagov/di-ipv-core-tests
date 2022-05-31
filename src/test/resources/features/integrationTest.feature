Feature: Full journey of Auth - Core - KBV -TxMA Integration
  Integration Checks (Black Box)
  Kenneth Decerqueira has got a valid GOV.UK account
  Kenneth Decerqueira, dob: 23-8-1959, passport expiry: 1-1-2030
  Address: 8 Hadley Road, Bath, BA2 5AA
  PASSPORT_NUMBER = 321654987
  email: simulate-delivered-3@notifications.service.gov.uk
  Password: Ariane1974.
  Mobile: +447700900222

  @integration_test
  Scenario: Happy path with Kenneth Decerqueira
    Given the user on `Sample Service - Staging` page
    And the user has 2FA enabled as well as P2 Level of confidence and claims ticked
    When the user clicks on `Continue`
    Then the new user is directed to the `Prove your identity with a GOVUK account page`
    When the new user selects `Continue to sign in or create a GOV.UK account`
    And the user clicks on `sign in`
    When the user enters their email address and click `Continue`
    And the user enters their password
    And the user enters their six digit code
