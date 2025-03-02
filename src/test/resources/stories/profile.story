Narrative:
As a user
I want to check my profile page
So that I can ensure my personal details are correct

Scenario: The user navigates from profile page to bookstore page
Given the user navigates to login page
When the user logs in with valid credentials
Then the user lands on profile page
When the user clicks on Go To Book Store button
Then the user lands on Book Store page

