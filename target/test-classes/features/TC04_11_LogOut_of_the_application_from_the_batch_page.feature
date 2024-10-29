#Author: Mathumathi Balakrishnan

Feature: LogOut of the application from the batch page

Background:
Given Admin is on the batch page for logout

Scenario: Validate logout option in the header is visible and enabled from the batch page
When Admin clicks on the logout button
Then Admin should see the Login screen Page

