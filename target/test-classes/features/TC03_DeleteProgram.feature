@LMS
Feature: Delete Program Feature
  I want to use this template for my feature file
  Background: Admin is on Program Page.
  @DP1
 Scenario: Delete Program button validation
Given Admin is on Program page
When  Admin clicks the Delete button in any of the row
Then  Admin sees the confirm Delete window box
@DP2
Scenario: yes button in the confirm window validation
Given  Admin is on confirm Delete window box
When   Admin clicks yes button
Then   Admin sees the Program is deleted with a success message
@DP3
Scenario:  No button in the confirm window validation
Given  Admin is on confirm Delete window box
When   Admin clicks No button
Then   There is no deletion
@DP4
Scenario:  Cross button in the confirm window validation
Given  Admin is on confirm Delete window box
When   Admin clicks cross button in the confirm Delete window
Then   Admin view the confirm Delete window box close