@MDDIP006-10102 @AccessTheWebsite @alsirbu
Feature: Check the API Website Access functionality

  Scenario Outline: Verify the Rest Assured Response Status Code 200 on accessing the website
    Given <typeOfRequest> Request is submitted
    Then <statusCode> Status code is provided
    Examples:
      | typeOfRequest | statusCode |
      | GET           | 200        |
