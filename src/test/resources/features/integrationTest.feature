Feature: Full journey of Auth - Core - KBV -TxMA Integration
  Integration Checks (Black Box)
  KENNETH DECERQUEIRA has got a valid GOV.UK account
  KENNETH DECERQUEIRA, dob: 23-08-1959, test dob: 23-08-1959, passport expiry: 01-01-2030
  Address: 8 Hadley Road, Bath, BA2 5AA
  PASSPORT_NUMBER = 321654987
  email: simulate-delivered-3@notifications.service.gov.uk
  Password: Ariane1974.
  Mobile: +447700900222


  @integration_test
  Scenario: Happy path with Kenneth Decerqueira
#    PHASE 1 - AUTH
    Given the user on `Sample Service - Staging` page
    And the user has 2FA enabled as well as P2 Level of confidence and claims ticked
    When the user clicks on `Continue`
    Then the new user is directed to the `Prove your identity with a GOVUK account page`
    When the new user selects `Continue to sign in or create a GOV.UK account`
    And the user clicks on `sign in`
    When the user enters their email address and click `Continue`
    And the user enters their password
    And the user enters their six digit code
    Then the user should be on `You’ve signed in to your GOV.UK account` page
#   PHASE 2:  PASSPORT CRI & ADDRESS CRI
    When the user clicks on `Continue` on `You’ve signed in to your GOV.UK account` page
    Then the user should be on `Enter your details exactly as they appear on your UK passport` page
    When the user enters their passport details and clicks on `Continue`
    Then the user should be on `What's your current home address` page
#    Then the event is logged in SQS `TxMA`
#    #Address cri test + Check TxMA
    When the user enters their postcode and click on `Find address` button
    And the user selects their address from the dropdown menu and click on `Select address` button
    And the user enters the year that they started living at that address
    Then the user should be shown their address and the move year on `Check your details` page
    When the user clicks on `Continue` on `Check your details` page
#    Then Address CRI S3 shows an evidence of activity
##  PHASE 3: FRAUD
    Then the user should land on `Fraud Check Stub` page
    When the user completes Fraud Check Stub
    Then the user should land on `Answer Security Questions` page
##    Then the confirmation is created in S3 (Backend test)
#  Then the user lands on `KBV CRI` page
##  PHASE 4: KBV
    When the user clicks `Continue` on `Answer Security Questions` page
    Then the user is shown the First Question
    When the user selects the correct answer and clicks `Continue`
    Then the user is shown the Second Question
    When the user selects the second correct answer and clicks `Continue`
    Then the user should be on `You have successfully proved your identity` page



#    #fraud cri test + Check TxMA
#    #kbv cri test + Check TxMA
#    #Check SPOT response (in AWS)


