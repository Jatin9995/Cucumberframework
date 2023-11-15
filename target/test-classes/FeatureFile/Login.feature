Feature: Login to nopcommerce.com
 I want to login to the nopcommerce.com website

@Sanity
  Scenario: Login with Valid credentials
    Given User launch chrome broswer
    When User open URL as "https://admin-demo.nopcommerce.com/login"
    And User enter Email id as "admin@yourstore.com" and Password as "admin"
    And user clicked on Login buttton
    Then page title should be "Dashboard / nopCommerce administration"
    When user click on logout button
    Then page title should be "Your store. Login"
    And user close the browser
    

    #Scenario Outline keyword is used for datadriven and Examples is used to provide the data
    
  @regression  
  Scenario Outline: Successful login with valid credentials DataDriven Testing (DDT)
    
    Given User launch chrome broswer
    When User open URL as "https://admin-demo.nopcommerce.com/login"
    And User enter Email id as "<email>" and Password as "<password>"
    And user clicked on Login buttton
    Then page title should be "Dashboard / nopCommerce administration"
    When user click on logout button
    Then page title should be "Your store. Login"
    And user close the browser

    Examples: 
      |email|password|
      |admin@yourstore.com|admin|
      |test@yourstore.com|admin|
