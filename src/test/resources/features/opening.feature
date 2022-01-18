
Feature: PYI_Core UI Flow
  @smoke
  @scenario_1
  Scenario: Navigating on Orchestrator Stub
    Given user is on Prove Your Identity page
    When user clicks on Prove Your Identity button
    Then user is on Credential Issuer page

  @licence-test
   Scenario: Open Government Licence Test
     Given user is on Prove Your Identity page
     When user clicks on Open Government Licence hyperlink
     Then user is is Open Government Licence page

#   @testing_firefox
#    Scenario: Testing firefox
#      Given user is in firefox page
#      When user chooses PYI
#      Then user is on core page

