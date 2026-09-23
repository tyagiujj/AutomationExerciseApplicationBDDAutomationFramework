Feature: Verify Search Product Functionality

  Scenario: Verify that search product functionality is working
    Given user is on the home page
    When user clicks on Products button
    Then Verify that ALL PRODUCTS heading is visible
    When Enter product name in search input and click search button
    #Then Verify 'SEARCHED PRODUCTS' is visible
    #Then Verify all the products related to search are visible
