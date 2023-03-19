@tag
Feature: Create Account

  @Create_Account
  Scenario Outline: Create Account in the Luma Application
    Given I landed on the Home page
    When I create an account giving firstname <firstname>, lastname <lastname>, email <email> and password <password> which already exists
    Then Alert Message "There is already an account with this email address. If you are sure that it is your email address" should be displayed

    Examples: 
      | firstname  | lastname | email                  |  password     |
      | SushmA     |     ASJ  | bujji@gmail.com        | bujji@143     |
      | Bujji      |     AS   | sushshay143@gmail.com  | sushshay@143  |
