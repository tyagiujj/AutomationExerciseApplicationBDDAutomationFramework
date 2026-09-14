Feature: Verify Test Cases Page

  Scenario: Verify that the Test Cases page is displayed correctly
    Given user is on the home page
    When user clicks on Test Cases button
    Then Verify that TEST CASES is visible
    Then Verify user is navigated to test cases page successfully
