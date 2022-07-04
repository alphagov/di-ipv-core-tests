Feature: Passport Test

  @passport_test
  Scenario Outline: Passport details page
    Given I am on Orchestrator Stub
    When I click on Debug route
    Then I should get five options
    When I click on ukPassport(Stub)
    Then I should be on `Enter your details exactly as they appear on your UK passport` page
    And user enters data as a <PassportSubject>
    And user clicks on continue
    Then user sees DCS check is complete message
    Examples:
      |PassportSubject     |
      |PassportSubjectHappy|

  @passport_test
  Scenario Outline: Invalid Passport Number
    Given I am on Orchestrator Stub
    When I click on Debug route
    Then I should get five options
    When I click on ukPassport(Stub)
    Then I should be on `Enter your details exactly as they appear on your UK passport` page
    And user enters data as a <PassportSubject>
    And user clicks on continue
    Then proper error message for invalid passport number should be displayed
    Examples:
      |PassportSubject      |
      |InvalidPassportNumber|

  @passport_test
  Scenario Outline: Invalid First Name
    Given I am on Orchestrator Stub
    When I click on Debug route
    Then I should get five options
    When I click on ukPassport(Stub)
    Then I should be on `Enter your details exactly as they appear on your UK passport` page
    And user enters data as a <PassportSubject>
    And user clicks on continue
    Then proper error message for invalid First Name should be displayed
    Examples:
      |PassportSubject |
      |InvalidfirstName|

  @passport_test
  Scenario Outline: Invalid Surname
    Given I am on Orchestrator Stub
    When I click on Debug route
    Then I should get five options
    When I click on ukPassport(Stub)
    Then I should be on `Enter your details exactly as they appear on your UK passport` page
    And user enters data as a <PassportSubject>
    And user clicks on continue
    Then proper error message for invalid Surname should be displayed
    Examples:
      |PassportSubject |
      |Invalidsurname|

  @passport_test
  Scenario Outline: Invalid Date of Birth
    Given I am on Orchestrator Stub
    When I click on Debug route
    Then I should get five options
    When I click on ukPassport(Stub)
    Then I should be on `Enter your details exactly as they appear on your UK passport` page
    And user enters data as a <PassportSubject>
    And user clicks on continue
    Then proper error message for invalid Date of Birth should be displayed
    Examples:
      |PassportSubject |
      |InvalidDateofBirth|

  @passport_test
  Scenario Outline: Invalid Passport Expiry Date
    Given I am on Orchestrator Stub
    When I click on Debug route
    Then I should get five options
    When I click on ukPassport(Stub)
    Then I should be on `Enter your details exactly as they appear on your UK passport` page
    And user enters data as a <PassportSubject>
    And user clicks on continue
    Then proper error message for invalid Expiry Date should be displayed
    Examples:
      |PassportSubject |
      |InvalidExpiryDate|