Feature: Passport Test @test

@passport_test
Scenario Outline: Passport details page
  Given user is on Prove Your Identity page
  And user enters "<Passport number>", "<Surname>", "<Given names>", "<birthDay>", "<birthMonth>", "<birthYear>", "<expiryDay>","<expiryMonth>" and "<expiryYear>"
  And user clicks on continue
  Then user sees DCS check is complete message
  Examples:
    | Passport number | Surname | Given names  | birthDay | birthMonth | birthYear | expiryDay | expiryMonth | expiryYear |
    | 824159121       | Watson  | Mary         | 01       | 03         | 2021      | 01        | 01          | 2030       |
    | 824159122       | Gok     | Hakan Thomas | 03       | 12         | 1980      | 01        | 01          | 2030       |

