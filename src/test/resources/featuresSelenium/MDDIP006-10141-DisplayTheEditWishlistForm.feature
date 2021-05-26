Feature: Wishlist Test Feature

  Background: Customer is login to hes wishlist page
    Given Navigate to wishlist page
    When Customer click on login button from header panel
    And Customer input login credentials
    Then Customer click login button
    And user is redirected to main dashboard page

  @MDDIP006-10141 @azol @Positive
  Scenario: Check all elements and labels in edit page is present
    Given Customer click to edit button
    When Edit popup is present
    Then All element is present



