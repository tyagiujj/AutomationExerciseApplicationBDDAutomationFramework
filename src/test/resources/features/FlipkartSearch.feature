Feature: Flipkart Homepage Verification

  Scenario: Verify Flipkart homepage loads successfully
    Given user is on the Flipkart homepage
    Then the page title should contain "Online Shopping"