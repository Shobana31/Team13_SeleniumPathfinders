@LMS
Feature: AddNewProgram feature
  I want to use this template for my feature file
  Background:
    Given Admin is successfully navigated to the Program Page
  @AP1
  Scenario: Add new program window popup display validation
    Given Admin  clicks on Program on the menu bar.
    When  Admin clicks on Add New Program button
    Then  Admin is able to see Program Details window pop up
	@AP2
  Scenario:  program details window Program name verification
    Given  Admin  clicks on Program on the menu bar.
    When  Admin clicks on Add New Program button
    Then   Admin is able to verify the Program Name field.
  @AP3
  Scenario:  program details window Program Description verification
    Given Admin  clicks on Program on the menu bar.
    When  Admin clicks on Add New Program button
    Then   Admin is able to verify the Program Description field.
  @AP4
  Scenario:  program details window Program Status verification
    Given Admin  clicks on Program on the menu bar.
    When  Admin clicks on Add New Program button
    Then   Admin is able to verify the Program Status field.
  @AP5
  Scenario:  program details window * verification
    Given Admin  clicks on Program on the menu bar.
    When  Admin clicks on Add New Program button
    Then   Admin is able to see "<*>" mark beside mandatory fields in the window.
  @AP6
  Scenario:  program details window validation with valid input
    Given  Admin enters valid input data in the program details window popup
    When   Admin clicks on save button.
    Then   Admin is able to see success message.
    #Then   Admin is able to validate the new added program
  @AP7
  Scenario:  empty form submission verification
    Given  Admin enters missing data on the program details window popup
    When   Admin clicks on save button.
    Then   Admin is able to see error message.
  @AP8
  Scenario:  Invalid Program Name validation
    Given   Admin enters invalid Program Name data on the program details window popup
    When   Admin clicks on save button.
    Then   Admin can see the error message.
  @AP9
  Scenario:  Invalid Program Description Validation
    Given   Admin enters Invalid Program Description data on the program details window popup
    When   Admin clicks on save button.
    Then   Admin can see error message displayed.
  @AP10
  Scenario:  Cancel button Validation
    Given   Admin enters Mandatory data on the program details window popup.
    When    Admin clicks on Cancel button.
    Then    Admin is unable to see the newprogram details save.
  @AP15
  Scenario:  X button Validation
    Given   Admin enters input data on the program details window popup.
    When   Admin clicks on X button.
   Then    Admin is able to see the window popup close.