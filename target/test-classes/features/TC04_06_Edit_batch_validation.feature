#Author: Mathumathi Balakrishnan

Feature: Edit batch validation

Background:
Given Admin is on the Batch Details Page

Scenario: Validate editing description and No. of classes fields with invalid data in the pop up
When Admin Updates any fields with invalid data and click save button
Then Admin should get a error message under the respective field

Scenario: validate save button in Batch details pop up
When Admin enters the valid data to all the mandatory fields and click save button 
Then Admin should get a succesesful message for editing the batch

Scenario: validate cancel button in Batch details pop up
When Admin enters the valid data to all the mandatory fields and click cancel button 
Then Admin can see the batch details popup closes without editing the batch




