Feature: Verify All Products and Product Detail Page

  Scenario: Verify that all products are visible and product detail page is displayed correctly
    Given user is on the home page
    When user clicks on  Products button
    Then Verify that ALL PRODUCTS heading is visible
