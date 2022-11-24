@login
Feature: Login feature

  Scenario: Login with valid credentials
    Given I navigate to the Login page
    When I enter valid login credentials
    Then I should be able to login and land on Loan Application page


#  Scenario: Login with invalid credentials
#    Given I navigate to the homepage
#    When I enter invalid login credentials
#    Then I should not be able to login
#
#   @noCredentials @smoke
#  Scenario: Login with no credentials
#    Given I navigate to the homepage
#    When I enter no login credentials
#    Then I should not be able to login
#
#  @smoke
#  Scenario: Login with valid credentials parametrized
#    Given I navigate to the homepage
#    When I enter login credentials as "duotechb10" and "tester"
#    Then I should be able to login and land on Welcome page
#
#
#  Scenario: Login with valid credentials parametrized 2
#    Given I navigate to the homepage
#    When I enter login credentials as "john.doe" and "tester"
#    Then I should be able to login and land on Welcome page
#
#
#
#  Scenario Outline: Login with valid credentials from examples tables
#    Given I navigate to the homepage
#    When I enter login credentials as "<username>" and "<password>"
#    Then I should be able to login and land on Welcome page
#
#    Examples:
#      | username   | password      |
#      | duotechb9  | tester        |
#      | john.doe   | tester        |
#      | donald.duck | donaldduck123 |