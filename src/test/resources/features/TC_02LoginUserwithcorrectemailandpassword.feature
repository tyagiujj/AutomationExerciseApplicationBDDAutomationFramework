Feature: Login User with correct email and password

  Scenario: Login with correct email and password
    Given user is on the home page
    When user clicks on Signup or Login button
    Then Login to your account section should be visible
    When user enters correct email and password
    And user clicks on Login button
    Then Verify that Logged in as username is visible