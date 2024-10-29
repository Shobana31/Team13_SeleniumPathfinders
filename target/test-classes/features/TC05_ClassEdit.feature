Feature: Validating edit popup details

Background: Admin in manage page after login
    Given Admin is in login page
    When Admin enter valid credentials
    Then Admin clicks classLink in navigation bar   
    
Scenario: Check if fields are updated with valid data
Given Admin in edit class popup
When Admin update fields with valid data and click save
Then Admin get message class details update successfully

Scenario: Check disabled batch name
Given Admin on manage page
When Admin click edit icon
Then Admin see batchname field is disabled

Scenario: Check disabled batch name
Given Admin on manage page
When Admin click edit icon
Then Admin see class topic field is disabled

Scenario: Validate cancel button on edit popup
Given Admin in edit class popup
When Admin click cancel button
Then Admin see the popup disappear and nothing changes

