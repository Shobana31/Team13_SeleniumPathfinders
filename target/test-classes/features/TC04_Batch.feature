#Author: Mathumathi Balakrishnan
Feature: Batch Page Navigation
Background:
Given Admin successfully Logged on to the LMS Portal
Scenario: Verify Admin Navigate to Batch page successfully
   Given Admin is on the Dashboard Page
   When Admin Clicks on the Batch menu from the header
   Then Admin should be in the Manage Batch Page