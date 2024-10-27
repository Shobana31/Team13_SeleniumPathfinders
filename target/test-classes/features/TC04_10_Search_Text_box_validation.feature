#Author: Mathumathi Balakrishnan

Feature: Search Text box validation

Background:
Given Admin is on the batch page for search

Scenario: validate serach box functionality
When Admin enters the batch name in the serach text box
Then Admin should see the filtered batches in the data table


