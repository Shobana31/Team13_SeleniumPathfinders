@all @programsearch

Feature: Search Text box validation

Background:
Given Admin is on the Program page for search

Scenario: validate serach box functionality
When Admin enters the program name in the serach text box
Then Admin should see the filtered program in the data table