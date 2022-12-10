@signup @regression
Feature: Sign Up feature



  Scenario: Sign up with random valid info
    Given I navigate to the Sign up page
    When I enter valid random info to sign up
    Then I should be able to login with created account and land on Loan Application page
    And  I should be able to see the same full name that I signed up with
