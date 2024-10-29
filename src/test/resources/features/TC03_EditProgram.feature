@LMS
Feature: Edit Program feature
  I want to use this template for my feature file
Background:
Given Admin is on Program page.
  @EP1
  Scenario: Verify title of the popup window
  Given   Admin is on Program page.
   When   Admin clicks on Edit Program button in any row
    Then   Admin is able to see Program Details window.
  @EP2
    Scenario: mandatory fields update verification with valid data
    Given   Admin is on Program Details window.
    When    Admin updates any mandatory with valid data clicking Save button.
    Then    Admin is able to see the success message
  @EP4
  Scenario:  mandatory fields update verification with Invalid data
    Given  Admin is on Program Details window.
    When   Admin updates any mandatory with Invalid data clicking Save button.
    Then   Admin will see the error message.
  @EP5
  Scenario:  mandatory fields update validation
    Given   Admin is on Program Details window.
    When    Admin updates all the mandatory fields with valid data clicking Save button.
    Then    Admin can validate updated program details.
  @EP6
  Scenario:  Cancel button Validation
    Given   Admin is on Program Details window.
    When    Admin updates any mandatory with valid data clicking Cancel button.
    Then    Admin cannot see the updated details.
  @EP7
  Scenario:  X button Validation
    Given   Admin is on Program Details window.
    When    Admin updates any mandatory with valid data clicking Cross button.
    Then    Admin views the window popup close.