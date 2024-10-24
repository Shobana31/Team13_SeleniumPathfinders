@LMS
Feature: Program feature
  I want to use this template for my feature file

 Background:
    Given Admin is in login page
    When  Admin enter valid credentials
    Then  Admin should land on the dashboard page 
  

  @P1
   Scenario: Program Page navigation validation scenario
    Given   Admin is on the Dashboard Page
    When    Admin selects Program from the menu
    Then    Admin is navigated to the Program page 
   
 