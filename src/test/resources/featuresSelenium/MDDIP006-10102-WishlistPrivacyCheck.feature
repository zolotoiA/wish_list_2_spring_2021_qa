@MDDIP006-10102 @AccessTheWebsite @alsirbu
Feature: User can see only his Wishlists

  Background:
    Given New User is created
    And User is logged in

  Scenario: Verify that User can see only his Wishlists
    Given No Wishlists are seen at the Main Dashboard
    When User Creates one new Wishlist
    And Only one Wishlist is seen at the Main Dashboard
    And User logs out
    And User logs into another account
    Then No Wishlists are seen at the Main Dashboard
