Feature: Passport Test

  Background:
    Given I am on Orchestrator Stub
    And I click on Debug route
    And I should get five options
    And I click on ukPassport(Stub)
    And I should be on `Enter your details exactly as they appear on your UK passport` page

  @passport_test
  Scenario Outline: Passport details page happy path
    Given user enters data as a <PassportSubject>
    When user clicks on continue
    Then I should see validity score 2 in the JSON payload
    And I should see Strength score 4 in the JSON payload

    Examples:
      |PassportSubject             |
      |PassportSubjectHappyDanny   |
      |PassportSubjectHappyKenneth |

  @passport_test
  Scenario Outline: Passport details page unhappy path
    Given user enters data as a <PassportSubject>
    When user clicks on continue
    Then proper error message for invalid passport number should be displayed
    Examples:
      |PassportSubject      |
      |InvalidPassportNumber|

  @passport_test
  Scenario Outline: Invalid First Name
    Given user enters data as a <PassportSubject>
    When user clicks on continue
    Then proper error message for invalid First Name should be displayed
    Examples:
      |PassportSubject |
      |InvalidfirstName|

  @passport_test
  Scenario Outline: Invalid Surname
    Given user enters data as a <PassportSubject>
    When user clicks on continue
    Then proper error message for invalid Surname should be displayed
    Examples:
      |PassportSubject |
      |Invalidsurname|

  @passport_test
  Scenario Outline: Invalid Date of Birth
    Given user enters data as a <PassportSubject>
    When user clicks on continue
    Then proper error message for invalid Date of Birth should be displayed
    Examples:
      |PassportSubject |
      |InvalidDateofBirth|

  @passport_test
  Scenario Outline: Invalid Passport Expiry Date
    Given user enters data as a <PassportSubject>
    When user clicks on continue
    Then proper error message for invalid Expiry Date should be displayed
    Examples:
      |PassportSubject |
      |InvalidExpiryDate|