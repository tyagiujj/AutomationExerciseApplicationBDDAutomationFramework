Feature: Register User with existing email

  Scenario: Register User with existing email
    Given user is on the home page
    When user clicks on Signup or Login button
    Then New User Signup section should be visible
    When user enters name and already registered email address
    And user clicks on Signup button
    Then Verify error 'Email Address already exists' is visible
