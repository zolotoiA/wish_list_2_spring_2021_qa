Feature: Wishlist Test Feature

  Background:
    Given Wishlist page is accessed
    When Customer click on Register button from header panel
    Then Register form is displayed

  @MDDIP006-10105 @AbilityToRegister @rsoh
  Scenario Outline: Check possibility to register new customer with valid data
    Given Customer enters valid"<fullName>", "<emailAddress>", "<password>", "<confirmPassword>"
    When Clicking on Register button
    Then Customer should be created and logged in
    Examples:
      | fullName                                           | emailAddress                             | password                  | confirmPassword           |
#   Successfully flow
      | John Isner                                         | 1    23@gmail.com                        | 123456789                 | 123456789                 |
#   fullName with boundary min and maximum
      | J                                                  | 1123@gmail.da                            | 12345678                  | 12345678                  |
      | AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA | 11123@gmail.da                           | 12345678                  | 12345678                  |
#                                                    Email address with boundary min and max
      | Bob                                                | a@b                                      | 12345678                  | 12345678                  |
      | Bob                                                | 1123aaaaaaaaaa22222222222222240@gmail.da | 1111111111111111111111111 | 1111111111111111111111111 |
#                                                                                                   Password with boundary min and max
      | Bob                                                | 2@gm                                     | Aa3$56789                 | Aa3$56789                 |
      | Bob                                                | 3@gm                                     | 1111111111111111111111125 | 1111111111111111111111125 |


  @MDDIP006-10105 @AbilityToRegister @rsoh
  Scenario Outline: Check possibility to register new customer with invalid data
    Given Customer enters invalid"<fullName>", "<emailAddress>", "<password>", "<confirmPassword>"
    When Clicking on Register button
    Then Error should be displayed "<errorMessage>"
    Examples:
      | fullName          | emailAddress   | password  | confirmPassword | errorMessage                                 |
#                         Not unique email address
      | John Isner Junior | a@mail.ru      | 123456789 | 123456789       | There is an existing account with this email |
#        fullName empty
      |                   | 1234@gmail.com | 123456789 | 123456789       | Please enter a full name                     |
#                     email negative
      | Boby              | @a             | 12345678  | 12345678        | Please enter a valid email address           |
      | Boby              | 1@aaa          | 12345678  | 12345678        | Please enter a valid email address           |
#                                         password short negative
      |                   | 33@gmail.com   | 1234567   | 1234567         | The password is too short                    |
#                                         password empty negative
      |                   | 33@gmail.com   |           | 1234567         | Please enter a password                      |
#                                              passwords do not confirm
      | Boby              | 333@gmail.com  | 12345678  | 111111111111    | Passwords do not match                       |

