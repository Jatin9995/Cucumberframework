Feature: Customer

Background: Steps common for all scenarios
Given User launch chrome broswer
    When User open URL as "https://admin-demo.nopcommerce.com/login"
    And User enter Email id as "admin@yourstore.com" and Password as "admin"
    And user clicked on Login buttton
    Then page title should be "Dashboard / nopCommerce administration"
  
   @Sanity
  Scenario: Add New Customer
    When User clicked on Customers Menu
    And Clicked on Customers Menu Item
    And Clicked on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And Clicked on save button
    Then user can view message "The new customer has been added successfully."
    And user close the browser
    
   @regression
     Scenario: Search customer by Email
    When User clicked on Customers Menu
    And Clicked on Customers Menu Item
    And User enter email id
   When Click on search button
   Then User should found email in the search table
    And user close the browser
    
    @regression
    Scenario: Search customer by name
    When User clicked on Customers Menu
    And Clicked on Customers Menu Item
    And User enter First name
    And User enter Last name
   When Click on search button
   Then User should found Name in the search table
    And user close the browser
     
    