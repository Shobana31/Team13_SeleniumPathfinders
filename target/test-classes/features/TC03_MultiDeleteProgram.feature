@all @ProgramMultiDelete

Feature: Validating Manage Program Page


Background:
Given Admin is logged in to LMS Portal


@ProgramMultiDelete-Positive

  	Scenario: Verify heading in manage program
    Given Admin is on Program module
    When Admin selects more than one program by clicking on the checkbox
		Then Programs get selected
		
@ProgramMultiDelete-Positive	
		Scenario: Verify Admin is able to delete Multiple programs
    Given Admin is on Program module
    When Admin clicks on the delete button on the left top of the program page
		Then Admin lands on Confirmation form
	
@ProgramMultiDelete-Positive	
		Scenario: Verify Admin is able to click Yes
    Given Admin is on Confirmation form
    When Admin clicks on Yes button
		Then Admin can see Successful  program deleted message

@ProgramMultiDelete-Positive		
		Scenario: Verify Admin is able to deleted program
		
    Given Admin is on Program module
    When Admin Searches for Deleted Program names
		Then There should be zero results
		

@ProgramMultiDelete-Positive	
		Scenario: Verify Admin is able to click No
		
    Given Admin is on Confirmation form
    When Admin clicks on No button
		Then Admin can see Programs are still selected and not deleted

@ProgramMultiDelete-Positive	
		Scenario: Verify Admin is able to close the window with X 
		
    Given Admin is on Program Confirm Deletion Page after selecting a program to delete
    When Admin Click on X button
		Then Admin can see Confirm Deletion form disappear
		