@MDDIP006-10107 @Burduja
Feature: Login button option

  Scenario: Check that Login form is displayed
    Given user is on landing page
    When user clicks Login button
    Then Login form is displayed
    And Email field is displayed
    And Password field is displayed
    And Login button is displayed