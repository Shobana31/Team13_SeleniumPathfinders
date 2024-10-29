Feature: Validating Search box, Sorting and Delete  in Class page

Background: Admin in manage page after login
Given Admin is in login page
When Admin enter valid credentials
Then Admin clicks classLink in navigation bar

Scenario: Search class by Batchname
Given Admin on manage page
When Admin enter batch name in the search textbox
Then Admin see class details are searched by batchname

Scenario: Search class by Classtopic
Given Admin on manage page
When Admin enter class topic in the search textbox
Then Admin see class details are searched by classtopic

Scenario: Search class by StaffName
Given Admin on manage page
When Admin enter staff name in the search textbox
Then Admin see class details are searched by staff name

Scenario: Sort class by Batchname
Given Admin on manage page
When Admin click batch name in the sort icon
Then Admin see class details are sorted by batchname

Scenario: Sort class by Classtopic
Given Admin on manage page
When Admin click class topic in the sort icon
Then Admin see class details are sorted by class topic

Scenario: Sort class by Class description
Given Admin on manage page
When Admin click class description in the sort icon
Then Admin see class details are sorted by class description

Scenario: Sort class by status
Given Admin on manage page
When Admin click class status in the sort icon
Then Admin see class details are sorted by class status

Scenario: Sort class by Class date
Given Admin on manage page
When Admin click class date in the sort icon
Then Admin see class details are sorted by class date

Scenario: Sort class by Staff name
Given Admin on manage page
When Admin click class staff name in the sort icon
Then Admin see class details are sorted by class staff name


#Scenario: Validate row level delete icon
#Given Admin on manage page
#When Admin click delete icon
#Then Admin see alert open with heading confirm with yes and no button

#Scenario: Click yes on delete icon
#Given Admin on manage page
#When Admin click yes option
#Then Admin see success class deleted message
#
#Scenario: Click no on delete
#Given Admin on manage page
#When Admin clicks no option 
#Then Admin see deletion alert disappears without deleting
#
#Scenario: Validate close icon on deletion alert
#Given Admin on manage page
#When Admin click close button
#Then Admin see alert disappears without any changes

