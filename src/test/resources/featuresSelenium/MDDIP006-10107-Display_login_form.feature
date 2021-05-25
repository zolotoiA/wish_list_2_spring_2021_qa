@MDDIP006-10107 @Burduja
Feature: Display login form

  Scenario: Check that Login form is displayed
    Given user is on landing page
    When user clicks Login button
    Then Login form is displayed to user
    And Email field is displayed to user
    And Password field is displayed to user
    And Login button is displayed to user