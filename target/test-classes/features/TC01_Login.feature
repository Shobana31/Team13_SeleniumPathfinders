Feature: Validating Login Page

  Scenario: Verify Admin is able to land on login page
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should land on the login

  Scenario: Verify Admin is able to land on dashboard page
    Given Admin is in login page
    When Admin enter valid credentials
    Then Admin should land on the dashboard page
    
    

    #Scenario: Verify Admin is able to land on login page
    #Given Admin launch the browser
    #When Admin gives incorrect LMS portal URL
    #Then Admin should receive error message
