Feature: User Registration on AutomationExercise

  Scenario: Register a new user successfully
    Given user is on the home page
    When user clicks on Signup or Login button
    Then New User Signup section should be visible
    When user enters random name and email for signup
    And user clicks on Signup button