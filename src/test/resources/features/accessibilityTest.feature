@accessibility_test
Feature: Checking accessibility issues

  Scenario: UI accessibility test
    Given I am on the test page
    When I run AXE Accessibility Test
    Then the number of accessibility issue detected must be zero