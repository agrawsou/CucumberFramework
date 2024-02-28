Feature: Homepage feature

  Background:
  Given user has already logged in to the application
  |username|password|
  |sourabh.agrawal200.sa@gmail.com|Bleedblue@01|

  Scenario: Homepage title
    Given user is on homepage
    When user gets the title of the home page
    Then the home title should be "Home Page"


  Scenario: Links count
    Given user is on homepage
    Then user gets links names
    |What's New|
    |Women|
    |Men|
    |Gear|
    |Training|
    |Sale|
    Then the links count should be 6
