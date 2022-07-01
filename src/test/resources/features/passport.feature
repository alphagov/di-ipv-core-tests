Feature: Passport Test

@passport_test
Scenario Outline: Passport details page
Given I am on Orchestrator Stub
  When I click on Debug route
  Then I should get five options
  When I click on ukPassport(Stub)
  Then I should be on `Enter your details exactly as they appear on your UK passport` page
  And user enters "<Passport number>", "<Surname>", "<Given names>", "<birthDay>", "<birthMonth>", "<birthYear>", "<expiryDay>","<expiryMonth>" and "<expiryYear>"
  And user enters "<Passport number>", "<Surname>", "<Given names>", "<birthDay>", "<birthMonth>", "<birthYear>", "<expiryDay>","<expiryMonth>" and "<expiryYear>"
  And user clicks on continue
  Then user sees DCS check is complete message
  Examples:
    | Passport number | Surname     | Given names  | birthDay | birthMonth | birthYear | expiryDay | expiryMonth | expiryYear |
    | 321654987       | DECERQUEIRA | KENNETH      | 25       | 11         | 1964      | 01        | 01          | 2030       |
    | 824159122       | Gok         | Hakan Thomas | 03       | 12         | 1980      | 01        | 01          | 2030       |

  @passport_test
  Scenario Outline: Invalid Passport Number
    Given I am on Orchestrator Stub
    When I click on Debug route
    Then I should get five options
    When I click on ukPassport(Stub)
    Then I should be on `Enter your details exactly as they appear on your UK passport` page
    And user enters "<Passport number>", "<Surname>", "<Given names>", "<birthDay>", "<birthMonth>", "<birthYear>", "<expiryDay>","<expiryMonth>" and "<expiryYear>"
    And user clicks on continue
    Then proper error message for invalid passport number should be displayed
    Examples:
      | Passport number | Surname     | Given names  | birthDay | birthMonth | birthYear | expiryDay | expiryMonth | expiryYear |
      | ABCDEDGHIJ      | DECERQUEIRA | KENNETH      | 25       | 11         | 1964      | 01        | 01          | 2030       |

  @passport_test
  Scenario Outline: Invalid First Name
    Given I am on Orchestrator Stub
    When I click on Debug route
    Then I should get five options
    When I click on ukPassport(Stub)
    Then I should be on `Enter your details exactly as they appear on your UK passport` page
    And user enters "<Passport number>", "<Surname>", "<Given names>", "<birthDay>", "<birthMonth>", "<birthYear>", "<expiryDay>","<expiryMonth>" and "<expiryYear>"
    And user clicks on continue
    Then proper error message for invalid First Name should be displayed
    Examples:
      | Passport number | Surname     | Given names  | birthDay | birthMonth | birthYear | expiryDay | expiryMonth | expiryYear |
      | 321654987       | DECERQUEIRA | KENN5^&      | 25       | 11         | 1964      | 01        | 01          | 2030       |

  @passport_test
  Scenario Outline: Invalid Surname
    Given I am on Orchestrator Stub
    When I click on Debug route
    Then I should get five options
    When I click on ukPassport(Stub)
    Then I should be on `Enter your details exactly as they appear on your UK passport` page
    And user enters "<Passport number>", "<Surname>", "<Given names>", "<birthDay>", "<birthMonth>", "<birthYear>", "<expiryDay>","<expiryMonth>" and "<expiryYear>"
    And user clicks on continue
    Then proper error message for invalid Surname should be displayed
    Examples:
      | Passport number | Surname      | Given names  | birthDay | birthMonth | birthYear | expiryDay | expiryMonth | expiryYear |
      | 321654987       | DECERQUE2%^  | KENNETH      | 25       | 11         | 1964      | 01        | 01          | 2030       |

  @passport_test
  Scenario Outline: Invalid Date of Birth
    Given I am on Orchestrator Stub
    When I click on Debug route
    Then I should get five options
    When I click on ukPassport(Stub)
    Then I should be on `Enter your details exactly as they appear on your UK passport` page
    And user enters "<Passport number>", "<Surname>", "<Given names>", "<birthDay>", "<birthMonth>", "<birthYear>", "<expiryDay>","<expiryMonth>" and "<expiryYear>"
    And user clicks on continue
    Then proper error message for invalid Date of Birth should be displayed
    Examples:
      | Passport number | Surname      | Given names  | birthDay | birthMonth | birthYear | expiryDay | expiryMonth | expiryYear |
      | 321654987       | DECERQUEIRA  | KENNETH      | AB       | 11         | 1964      | 01        | 01          | 2030       |

  @passport_test
  Scenario Outline: Invalid Passport Expiry Date
    Given I am on Orchestrator Stub
    When I click on Debug route
    Then I should get five options
    When I click on ukPassport(Stub)
    Then I should be on `Enter your details exactly as they appear on your UK passport` page
    And user enters "<Passport number>", "<Surname>", "<Given names>", "<birthDay>", "<birthMonth>", "<birthYear>", "<expiryDay>","<expiryMonth>" and "<expiryYear>"
    And user clicks on continue
    Then proper error message for invalid Expiry Date should be displayed
    Examples:
      | Passport number | Surname      | Given names  | birthDay | birthMonth | birthYear | expiryDay | expiryMonth | expiryYear |
      | 321654987       | DECERQUEIRA  | KENNETH      | 25       | 11         | 1964      | AB        | 01          | 2030       |