Feature: Passport API tests

  @passport_api_tests
  Scenario: Testing API with valid passport
    Given I am an authorised person
    When I send a GET request with valid UK passport
    Then I should get passport valid message

