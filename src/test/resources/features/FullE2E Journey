Feature: Testing `Full E2E journey route` on Sample service staging Stub. Happy path with Kenneth Decequeria

  @Full_journey_route
  
  Scenario: UI and Accessibility tests of `Full journey route`
    Given I am on Staging service sample Stub
    When I click on `P2` AND 'Continue'
    Then I should be on `sign-in-or-create` page
    And I click on 'sign in'
    When I enter a registered 'email address'
    And  I click `Continue`
    Then I should be able to enter a 'valid password` 
    And I click 'Continue'
    When I enter a '6 digit-code' generated to the registered mobile phone
    Then I should be able to click 'continue'
    When I land on 'Passport CRI'
    Then I should be able to enter 'Kenneth Decequeria' Passport Details 
    And I click 'continue' 
    Then I should land on 'Address CRI' 
    When I enter a valid UK Postcode within 'What's your current home address?'
    And I Click 'Continue' 
    Then I should be able to select my address from the 'dropdown list'
    And I click 'Select Address'
    When I Input a  valid Year which is <1 years in "When did you start living at this address?'
    And I click 'Continue'
    And I should be able to click on 'I confirm that my details are correct'
    Then I should be on Fraud Check And I can prove my identity
    And I Click 'Continue'
    Then I should be on `Answer security questions` page 
    And I Click 'Start' I should be taken to KBV CRI Staging (Stub)
    Then the user is shown the first KBV question
    When the user answers the first question correctly
    Then the user is shown the second KBV question
    When the user answers the second KBV question correctly
    Then the user is shown the third KBV question
    When the user answers the third KBV question correctly
    Then I should be taken to 'You've successfully proved your Identify'
