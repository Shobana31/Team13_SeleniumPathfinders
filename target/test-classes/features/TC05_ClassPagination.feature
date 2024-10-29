Feature: Validating Pagination in Class page

Background: Admin in manage page after login
Given Admin is in login page
When Admin enter valid credentials
Then Admin clicks classLink in navigation bar

Scenario: Verify next page link
Given Admin on manage page
When Admin click next page link
Then Admin should see the next page record with link enabled

Scenario: Verify last page link
Given Admin on manage page
When Admin clicks last page link
Then Admin should see the last page record with next link disabled

Scenario: Verify previous page link
Given Admin on manage page
When Admin click previous  page link
Then Admin should see the previous page record with link enabled

Scenario: Verify first page link
Given Admin on manage page
When Admin clicks  first page link
Then Admin should see the first page record with previous link disabled
