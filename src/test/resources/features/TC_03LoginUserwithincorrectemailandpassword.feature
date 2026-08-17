Feature: Login user with incorrect email and password

  Scenario: Login user with incorrect email and password
    Given user is on the home page
    When user clicks on Signup or Login button
    Then Login to your account section should be visible
    When user enters incorrect email and password
    And user clicks on Login button
    Then Verify error Your email or password is incorrect is visible