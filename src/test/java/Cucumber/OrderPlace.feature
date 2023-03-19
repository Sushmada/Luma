@tag
Feature: Order Place

  @Order_Place
  Scenario: Order Place
    Given I landed on the Home page
    When I place order
    Then Confirmation message "Thank you for your purchase!" is displayed
