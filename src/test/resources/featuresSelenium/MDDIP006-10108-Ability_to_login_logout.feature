@MDDIP006-10108 @Burduja
Feature: Ability to log in/log out

  Background:
    Given user is on landing page
    When user clicks Login button
    Then Login form is displayed to user

  @PositiveScenario
  Scenario Outline: User login with existing data
    Given user enters valid data in '<email>' and '<password>' field
    When user clicks Login button on login form
    Then user is redirected to main dashboard page '<greetingMessage>'
    Examples:
      | email                       | password          | greetingMessage              |
      | johndoe@email.com           | johndoemaster     | Welcome back, John Doe       |
      | steve.robinson06#@gmail.com | stevedabest967#@$ | Welcome back, Steve Robinson |

  @NegativeScenario
  Scenario Outline: Login with blank mandatory fields
    Given user leaves mandatory fields blank
    When user clicks Login button on login form
    Then user gets error messages displayed under '<email>','<password>' fields
    Examples:
      | email                              | password                |
      | Please enter a valid email address | Please enter a password |

  @NegativeScenario
  Scenario Outline: Login with wrong credentials
    Given user enters a wrong email or password in '<email>','<password>' fields
    When user clicks Login button on login form
    Then user gets error messages displayed '<wrongEmailPasswordMessage>'
    Examples:
      | email                  | password             | wrongEmailPasswordMessage |
      | johndoe@email.com      | johndoewrongpassword | Wrong email or password   |
      | johndoewrong@email.com | johndoemaster        | Wrong email or password   |

  @NegativeScenario
  Scenario Outline: Login with spaces instead of valid email or password credentials
    Given user enters spaces instead of valid credentials in '<email>','<password>' fields
    When user clicks Login button on login form
    Then user gets error messages displayed '<wrongEmailPasswordMessage>'
    Examples:
      | email             | password      | wrongEmailPasswordMessage          |
      | j      @email.com | johndoemaster | Please enter a valid email address |
      | johndoe@email.com |               | Wrong email or password            |
      | johndoe@email.com | da    dsad    | The password contains white spaces |
