Feature: Logout user

  Scenario: Logout user
    Given user is on the home page
    When user clicks on Signup or Login button
    Then Login to your account section should be visible
    When user enters correct email and password
    And user clicks on Login button
    Then Verify that Logged in as username is visible
    When user clicks on Logout button
    Then Verify that Login to your account is visible