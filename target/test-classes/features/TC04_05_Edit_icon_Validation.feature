#Author: Mathumathi Balakrishnan

Feature: Admin is on the batch page

Background:
Given Admin is on the batch page

Scenario: Validate Edit icon feature in any row
When Admin clicks the edit icon
Then Admin should see the Batch details pop up window

Scenario: Validate program name  value is disabled to edit
When Admin clicks the edit icon
Then Admin should see Program name value field is disabled for editing

Scenario: Validate batch name  value is disabled to edit
When Admin clicks the edit icon
Then Admin should see batch name value field is disabled for editing




