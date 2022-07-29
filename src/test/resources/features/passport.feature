Feature: Passport Test

  Background:
    Given I am on Orchestrator Stub
    And I click on Debug route
    And I should get five options
    And I click on ukPassport(Stub)
    And I should be on `Enter your details exactly as they appear on your UK passport` page

  @passport_test @Smoke @Regression @PYIC-1570
  Scenario Outline: Passport details page happy path
    Given user enters data as a <PassportSubject>
    When user clicks on continue
    Then I should see validity score 2 in the JSON payload
    And I should see Strength score 4 in the JSON payload

    Examples:
      |PassportSubject             |
      |PassportSubjectHappyDanny   |
      |PassportSubjectHappyKenneth |
      |PassportSubjectHappySuzie   |
      |PassportSubjectHappySandra  |
      |PassportSubjectHappyBen     |
      |PassportSubjectHappyAlex    |

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

  @passport_test @PYIC-1570
  Scenario Outline: Passport Retry Test Happy Path
    Given user enters invalid passport details
    When user clicks on continue
    Then proper error message for could not find details is displayed
    When user Re-enters data as a <PassportSubject>
    And user clicks on continue
    Then I should see validity score 2 in the JSON payload
    And I should see Strength score 4 in the JSON payload
    Examples:
      |PassportSubject             |
      |PassportSubjectHappyKenneth |

  @passport_test @PYIC-1570
  Scenario Outline: Passport Retry Test Invalid Passport
    Given user enters invalid passport details
    When user clicks on continue
    Then proper error message for could not find details is displayed
    When user Re-enters data as a <PassportSubject>
    And user clicks on continue
    Then we cannot prove your identity right now error page is displayed
    Examples:
      |PassportSubject |
      |InvalidPassport |

  @PYIC-1636
  Scenario Outline: Passport Escape route unable to prove identity unhappy path
    Given User click on ‘prove your identity another way' Link
    When user click on Prove your identity another way radio button
    Then user should be redirected to Sorry there is a problem with the service

  @passport_test @PYIC-1636
  Scenario Outline: Passport Escape route happy path
    Given User click on ‘prove your identity another way' Link
    When user click on Enter passport details to prove identity radio button
    Then User should be redirected back to passport page
    When user enters data as a <PassportSubject>
    And user clicks on continue
    Then I should see validity score 2 in the JSON payload
    And I should see Strength score 4 in the JSON payload
    Examples:
      |PassportSubject             |
      |PassportSubjectHappyDanny   |

  @passport_test @PYIC-1636
  Scenario Outline: Passport Escape Route 2nd retry Happy Path
    Given user enters invalid passport details
    When user clicks on continue
    Then proper error message for could not find details is displayed
    When User click on ‘prove your identity another way' Link
    And user click on Enter passport details to prove identity radio button
    Then User should be redirected back to passport page
    When user Re-enters data as a <PassportSubject>
    And user clicks on continue
    Then I should see validity score 2 in the JSON payload
    And I should see Strength score 4 in the JSON payload
    Examples:
      |PassportSubject             |
      |PassportSubjectHappyDanny   |

  @passport_test @PYIC-1636
  Scenario Outline: Passport Escape Route 2nd retry Unhappy Path
    Given user enters invalid passport details
    When user clicks on continue
    Then proper error message for could not find details is displayed
    When User click on ‘prove your identity another way' Link
    And user click on Enter passport details to prove identity radio button
    Then User should be redirected back to passport page
    When user Re-enters data as a <PassportSubject>
    And user clicks on continue
    Then we cannot prove your identity right now error page is displayed
    Examples:
      |PassportSubject             |
      |InvalidPassport             |