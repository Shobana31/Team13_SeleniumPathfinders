#Author: Mathumathi Balakrishnan

Feature: Delete batch validation

Background: 
Given Admin is on the batch page for Delete

Scenario: validate delete Icon on any row in delete batch 
When Admin clicks the delete Icon on any of the row 
Then Admin should see the confirm alert box with yes and no button

Scenario: Validate yes button on the confirm alert box in delete batch 
When Admin clicks on the delete icon and click yes buttton
Then Admin should see the successfull message and the batch should be deleted

Scenario: validate no button on the confirm alert box in delete batch 
When Admin clicks on the delete icon and click no buttton
Then Admin should see the alert box closed and the batch is not deleted

Scenario: validate close Icon on the alert box in delete batch 
When Admin clicks on the close icon on alert box
Then Admin should see the alert box closed 


