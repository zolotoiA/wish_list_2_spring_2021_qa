Feature: Ability to register API

  @MDDIP006-10105 @AbilityToRegister @rsoh
  Scenario Outline: Check register new customer with valid data
    When Customer enters valid"<fullName>", "<emailAddress>", "<password>", "<confirmPassword>" and click register
    Then Customer should be created and logged in the system
    Examples:
      | fullName | emailAddress       | password | confirmPassword |
      | Kris     | didddads@mail.ru | password | password        |


  @MDDIP006-10105 @AbilityToRegister @rsoh
  Scenario Outline: Check register new customer with existing email
    When Customer enters valid credentials "<fullName>", "<emailAddress>", "<password>", "<confirmPassword>" and click register
    Then Error message is displayed
    Examples:
      | fullName | emailAddress | password | confirmPassword |
      | KrisAs   | kris@mail.ro | password | password        |

  @MDDIP006-10105 @AbilityToRegister @rsoh
  Scenario Outline: Check possibility to register new customer with invalid data
    When Customer enter invalid"<fullName>", "<emailAddress>", "<password>", "<confirmPassword>" and click register
    Then Customer account is not registered
    Examples:
      | fullName | emailAddress   | password  | confirmPassword |
#        fullName empty
      |          | 1234@gmail.com | 123456789 | 123456789       |
#                     email negative
      | Boby     | @a             | 12345678  | 12345678        |
      | Boby     |                | 12345678  | 12345678        |
#                                         password short negative
      |          | 33@gmail.com   | 1234567   | 1234567         |
#                                         password empty negative
      |          | 33@gmail.com   |           | 1234567         |
#                                              passwords do not confirm
      | Boby     | 333@gmail.com  | 12345678  | 111111111111    |

