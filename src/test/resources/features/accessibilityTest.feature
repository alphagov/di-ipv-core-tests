
Feature: Checking accessibility issues

  @accessibility_test
  Scenario: UI accessibility test
    Given I am on the test page
    When I run AXE Accessibility Test
    Then the number of `Critical` or `Severe` or `Serious` issues detected must be zero

  @accessibility_multiple
  Scenario Outline: Testing multiple pages
    Given I am on the "<Test Page>"
    When I run AXE Accessibility Test
    Then the number of `Critical` or `Severe` or `Serious` issues detected must be zero

    Examples:
    | Test Page     |
    | successUrl    |
    | transitionUrl |
    | startUrl      |



