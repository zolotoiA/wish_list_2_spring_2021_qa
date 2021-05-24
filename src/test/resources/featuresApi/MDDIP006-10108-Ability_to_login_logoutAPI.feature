@API @MDDIP006-10108 @Burduja
Feature: Ability to login/logout API

  @PositiveScenario
  Scenario Outline: User login with existing data API
    When user enters valid <email> and <password>
    Then user should be logged in his account with <wishlists> displayed
    Examples:
      | email                       | password          | wishlists  |
      | johndoe@email.com           | johndoemaster     | [550, 551] |
      | steve.robinson06#@gmail.com | stevedabest967#@$ | []         |
      | edward.1992@mail.ri         | CUsERcaRinct      | [577]      |

  @NegativeScenario
  Scenario Outline: Login with wrong credentials API
    When user enters a wrong email or password '<email>','<password>'
    Then user is rejected by the server due to wrong credentials
    Examples:
      | email                  | password             |
      | johndoe@email.com      | johndoewrongpassword |
      | johndoewrong@email.com | johndoemaster        |

  @NegativeScenario
  Scenario Outline: Login with unexisting/invalid credentials API
    When user enters a wrong email or password '<email>','<password>'
    Then user gets error message displayed due to invalid data
    Examples:
      | email                  | password      |
      | johndoewrong@email.com |               |
      | johndoe@!@#$email.com  | joe   doe     |
      |                        | johndoemaster |
#Blank fields
      |                        |               |