Feature: Customers

  Background:Below are the common steps for each scenario
    Given User Launch Chrome browser
    When  User opens URL "http://admin-demo.nopcommerce.com"
    And   User enters Email as "admin@yourstore.com" and Password as "admin"
    And   Click on login
    Then  User can view Dashboard

  @sanity
  Scenario: Add new Customer
    When  User click on customers Menu
    And   click on customers Menu Item
    And   click on Add new button
    Then  User can view Add new customer page
    When  User enter customer info
    And   click on Save button
    Then  User can view confirmation message "The new customer has been added successfully."
    And   close browser

  @sanity
  Scenario: Search Customer by EmailID
    When  User click on customers Menu
    And   click on customers Menu Item
    And   Enter customer Email
    When  Click on search button
    Then  User should find Email in the search table
    And   close browser

  Scenario: Search Customer by Name
    When  User click on customers Menu
    And   click on customers Menu Item
    And   Enter customer FirstName
    And   Enter customer LastName
    When  Click on search button
    Then  User should find Name in the search table
    And   close browser