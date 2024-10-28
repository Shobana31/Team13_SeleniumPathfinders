Feature: Validating Search box in Class page

Background: Admin in manage page after login
Given Admin is in login page
When Admin enter valid credentials
Then Admin clicks classLink in navigation bar

#Scenario: Search class by Batchname
#Given Admin on manage page
#When Admin enter batch name in the search textbox
#Then Admin see class details are searched by batchname
#
#Scenario: Search class by Classtopic
#Given Admin on manage page
#When Admin enter class topic in the search textbox
#Then Admin see class details are searched by classtopic

Scenario: Search class by StaffName
Given Admin on manage page
When Admin enter staff name in the search textbox
Then Admin see class details are searched by staff name
