Feature: Display register form

  @MDDIP006-10878 @RegisterFormDisplaying @mcerchez
  Scenario: Registration pop-up
    Given Wishlist homepage is accessed
    When user clicks on Register button
    Then the registration pop-up is displayed

  @MDDIP006-10878 @RegisterFormDisplaying @mcerchez
  Scenario: Registration form content
    Given registration form is displayed
    When user access the registration form
    Then the Full Name element is present
    And the Email Address element is present
    And the Password element is present
    And the Confirm Password element is present
    And the Register Button element is present

  @MDDIP006-10878 @RegisterFormDisplaying @mcerchez
  Scenario Outline: <field> attributes
    Given registration form is displayed
    When user access a <field>
    Then the field <label> with an asterisk is displayed

    Examples:
      | field            | label              |
      | Full Name        | Full Name*         |
      | Email Address    | Email*             |
      | Password         | Password*          |
      | Confirm Password | Confirm Password*  |