@all @Program
Feature: Validating Manage Program Page


Background:
Given Admin is logged in to LMS Portal
			


@Program-Positive
  Scenario: Verify heading in manage program
    Given Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
		Then Admin should see the heading Manage Program
		
@Program-Positive
Scenario: Verify view details of programs
    Given Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should able to see Program name, description, and status for each program

@Program-Positive    
Scenario: Verify the Multiple Delete button state 
    Given Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see a Delete button in left top is disabled
    
@Program-Positive    
Scenario: Verify the Search button  
    Given Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see Search bar with text as Search...
 

@Program-Positive   
Scenario: Verify column header name of data table 
    Given Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see data table with column header on Manage Program Page as  Program Name, Program Description, Program Status, Edit or Delete
   
@Program-Positive 
Scenario: Verify checkbox default state beside Program Name column header
    Given Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see checkbox default state as unchecked beside Program Name column header

@Program-Positive
Scenario: Verify checkboxes default state beside each Program names in the data table
    Given Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see check box default state as unchecked on the left side in all rows against program name 
 
 
@Program-Positive  
Scenario: Verify Sort icon in manage program
    Given Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the sort arrow icon beside to each column header except Edit and Delete 

@Program-Positive
 Scenario: Verify pagination icons below data table in manage program
    Given Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the text as Showing x to y of z entries along with Pagination icon below the table. x- starting record number on that page.	y-ending record number on that page. z-Total number of records
    
Scenario: Verify footer message in manage program
    Given Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the footer as In total there are z programs.z- Total number of records