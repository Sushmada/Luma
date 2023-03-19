@tag
Feature: Sign In

  @Sign_In
  Scenario Outline: Sign In to the Luma application
    Given I landed on the Home page
    When I logged in to the app with email <email> and password <password>
    Then Greeting message "Welcome," is displayed

    Examples: 
      | email 								| password     |
      | sushshay143@gmail.com | sushshay@143 |
      | bujji@gmail.com				| bujji@143    |
