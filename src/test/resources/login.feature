@login @regression
Feature: Login feature



  Background: Common steps for all scenarios
    Given I navigate to the Login page

  Scenario: Login with valid credentials
    When I enter valid login credentials
    Then I should be able to login and land on Loan Application page

  Scenario: Login with valid credentials parametrized
    When I enter login credentials as "tomhil@inbox.ru" and "tomhil"
    Then I should be able to login and land on Loan Application page

