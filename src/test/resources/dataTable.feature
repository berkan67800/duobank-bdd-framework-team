@datatable @regression
Feature: Data Table Implementations



  Background: Common steps for all scenarios
    Given I navigate to the Login page
    Then I enter valid login credentials
    And I click Mortgage Application option from the left menu

  Scenario: Fill the preapproval form with Data Table info
    When  I add the following info to the preapproval form
      | realtorName | purchasePrice | downPayment |
      | John Parker | 5000          | 50000       |
    And   I click the next button
    Then  I should be able to see Personal Information step


  Scenario: Fill the Employment and Income step with Data Table
    When  I add the following info to the preapproval form
      | realtorName | purchasePrice | downPayment |
      | John Parker | 500000        | 5000        |
    And   I click the next button
    Then  I should be able to see Personal Information step
    And   I enter valid information to the Personal Information form
    And   I click the next button
    And   I should be able to navigate to the Expenses step
    When  I fill the Expenses step and click next button
    And   I should be able to land Employment and Income step
    And   I fill the Employment and Income step following valid information
      | employerName | position | city      | state | startDate  | grossMonthlyIncome | incomeSource       | amount |
      | John Doo     | SDET     | Chantilly | AM    | 10.01.2020 | 5000               | otherTypesOfIncome | 1750   |
    And   I click the next button
    Then  I should be able to land Credit Report step