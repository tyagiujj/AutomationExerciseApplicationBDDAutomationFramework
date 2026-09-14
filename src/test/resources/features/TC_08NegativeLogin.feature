Feature: Negative Login Test

  Background:
    Given user is on the home page
    When user clicks on Signup or Login button

  @validLogin
  Scenario Outline: User tries to login with valid credentials
    When user enters "<email>" and "<password>"
    And user clicks on Login button
    Then Verify that Logged in as username is visible

    Examples:
      | email             | password  |
      | Test@62gmail.com  | Test@1234 |

  @invalidLogin
  Scenario Outline: User tries to login with invalid credentials
    When user enters "<email>" and "<password>"
    And user clicks on Login button
    Then Verify that error message is visible

    Examples:
      | email             | password   |
      | Test@62gmail.com  | Test@12345 |
      | Test@63gmail.com  | Test@1234  |
      | Test@63gmail.com  | Test@12345 |