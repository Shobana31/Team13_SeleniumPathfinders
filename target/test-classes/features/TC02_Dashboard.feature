Feature: Validating Dashboard Page

Background:
    Given Admin is in login page
    
  Scenario: Verify after login Admin lands on dashboard page
   When Admin enter valid credentials and clicks login button
   Then Admin should see dashboard
   
   Scenario: Verify the response time
      When Admin enter valid credentials and clicks login button
      Then Maximum navigation time in milliseconds, defaults to 30 seconds
      
    Scenario: Verify LMS title
    When Admin enter valid credentials and clicks login button
    Then Admin should see LMS -Learning management system as title
    
    
    Scenario: Validate navigation bar text
     When Admin enter valid credentials and clicks login button
    Then Admin should see correct spelling in navigation bar text
    
    Scenario: Validate LMS title has correct spelling and space
    When Admin enter valid credentials and clicks login button
    Then Admin should see correct spelling and space in LMS title
   
