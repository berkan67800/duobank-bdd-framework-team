@datatable @regression
Feature: Data Table Implementations



  Background: Common steps for all scenarios
    Given I navigate to the Login page
    Then I enter valid login credentials
    And I click Mortgage Application option from the left menu

  Scenario: Fill the preapproval form with Data Table info
    When  I add the following info to the preapproval form
      | realtorName | purchasePrice | downPayment |
      | John Parker | 5000          | 50000        |
    And   I click the next button
    Then  I should be able to see Personal Information step


