Feature: Login  Page Verification

  @Login-Positive
  Scenario: Verify Admin is able to land on login page
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should land on the login page

  @Login-Negative
  Scenario: Verify Admin is able to land on home page with invalid URL
    Given Admin launch the browser
    When Admin gives the invalid LMS portal URL
    Then Admin should recieve 404 page not found error

  @Login-Positive
  Scenario: Verify for broken link
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then HTTP response >= 400. Then the link is broken

  @Login-Positive
  Scenario: Verify the text spelling in the page
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see correct spellings in all fields

  @Login-Positive
  Scenario: Verify the company logo
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see logo on the left  side

  @Login-Positive
  Scenario: Verify application name
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see  LMS - Learning Management System

  @Login-Positive
  Scenario: Verify company name
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see company name below the app name

  @Login-Positive
  Scenario: Validate sign in content
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see "Please login to LMS application"

  @Login-Positive
  Scenario: Verify text field is present
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see two text field

  @Login-Positive
  Scenario: Verify text on the first text field
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should "User" in the first text field

  @Login-Positive
  Scenario: Verify asterik next to Admin text
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see field mandatory (*) symbol next to Admin text

  @Login-Positive
  Scenario: Verify text on the second text field
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should "Password" in the second text field

  @Login-Positive
  Scenario: Verify asterik next to password text
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see * symbol next to password text

  @Login-Positive
  Scenario: Verify the alignment input field for the login
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see input field on the centre of the page

  @Login-Positive
  Scenario: verify Login button is present
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see login button

  @Login-Positive
  Scenario: Verify the alignment of the login button
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see login button on the centre of the page

  @Login-Positive
  Scenario: Verify input descriptive test in Admin field
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see Admin in gray color

  @Login-Positive
  Scenario: Verify input descriptive test in password field
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see password in gray color

Scenario: Validate login with valid credentials
 Given Admin is in login Page
When Admin enter valid credentials  and clicks login button 
Then Admin should land on dashboard page 

  Scenario Outline:  Validate login with invalid credentials
    Given Admin is in login Page
    When Admin enter invalid credentials  and clicks login button
    Then Admin should land on dashboard page ( centre of the page will be empty , menu bar is present).

    Examples:
      | username       | password          |
      | sdet@gmail.com | LmsHackathon@2024 |
      | invalid        | invalid           |
      |                | LmsHackathon@2024 |
      | sdet@gmail.com |                   |

