Feature: Login Page Feature

Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then the title should be "Customer Login"

Scenario: Forgot Pass Link
Given user is on login page
Then forgot password link should be displayed

Scenario: Login to application
Given user is on login page
When user enters username "sourabh.agrawal200.sa@gmail.com"
And enters password "Bleedblue@01"
And user clicks on login button
Then user gets the title of the page
And the title should be "Home Page"