Feature: Contact Us Form

  Scenario: Verify that the Contact Us form is displayed correctly
    Given user is on the home page
    When user clicks on Contact Us button
    Then Verify that GET IN TOUCH is visible
    And user enters name, email, subject and message
    And user uploads a file
    And user clicks on Submit button
    Then Verify success message 'Success! Your details have been submitted successfully.' is visible
    And user clicks on Home button and verify that landed to home page successfully