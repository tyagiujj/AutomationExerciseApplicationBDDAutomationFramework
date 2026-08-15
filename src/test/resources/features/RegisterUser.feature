Feature: User Registration on AutomationExercise

  Scenario: Register a new user successfully
    Given user is on the home page
    When user clicks on Signup or Login button
    Then New User Signup section should be visible
    When user enters random name and email for signup
    And user clicks on Signup button
    Then Verify that ENTER ACCOUNT INFORMATION is visible
    When user select the title radio button
    And user enters random password
    And user selects date of birth form dropdown
    And user select month of birth form dropdown
    And user select year of birth form dropdown
    And user selects checkbox for newsletter
    And user selects checkbox for special offers
    And user enters first name and last name
    And user enters company name
    And user enters address
    And user enters address2
    And user selects country from dropdown
    And user enters state
    And user enters city
    And user enters zipcode
    And user enters mobile number
    And user clicks on Create Account button
    Then Verify that Account Created is visible
    And user clicks on Continue button
    Then Verify that Logged in as username is visible
    And user clicks on Delete Account button
    Then Verify that ACCOUNT DELETED! is visible and click on Continue button