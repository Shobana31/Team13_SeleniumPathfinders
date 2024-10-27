#Author: Mathumathi Balakrishnan

Feature: Add New Batch

Background:
Given Admin is on the Batch page

Scenario: Verify sub menu displayed in batch menu bar
When Admin clicks "Batch" on the navigation bar
Then Admin should see sub menu in menu bar as "Add New Batch"

Scenario: Validate Admin able to click on the Add new Batch Option
When Admin clicks on "Add New batch" under the "batch" menu bar
Then Admin should see the Batch Details pop up window


