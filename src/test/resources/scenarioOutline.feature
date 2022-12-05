Feature: Scenario Outline Implementations



  Background: Common steps for all scenarios
    Given I navigate to the Login page
    Then I enter valid login credentials
    And I click Mortgage Application option from the left menu

  @scenarioOutline
  Scenario Outline: Fill the Personal Information form with valid data
    When  I add valid information to the preapproval form
    And   I click the next button
    And   I enter the following info to Personal Information form
      | firstName   | lastName   | email   | dateOfBirth   | SSN   | maritalStatus   | cellPhone   |
      | <firstName> | <lastName> | <email> | <dateOfBirth> | <SSN> | <maritalStatus> | <cellPhone> |
    And   I click the next button
    Then  I should be able to navigate to the Expenses step

  Examples:
    | firstName | lastName | email             | dateOfBirth | SSN       | maritalStatus | cellPhone  |
    | John      | Doe      | john123@gmail.com     | 12121990    | 666553454 | Married       | 5554443434 |
    | Walter    | White    | walterwhite@gmail.com | 03031987    | 123121212 | Divorced      | 6573425454 |



    Scenario Outline: Fill the eConcent form with valid data
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
        | employerName | position | city      | state | startDate  | grossMonthlyIncome | incomeSource          | amount |
        | John Doo     | SDET     | Chantilly | AM    | 10.01.2020 | 5000               | Other Types Of Income | 1750   |
      And   I click the next button
      Then  I should be able to land Credit Report step
      And   I click the next button
      And   I add the following info to eConsent page
        | firstName   | lastName   | email   |
        | <firstName> | <lastName> | <email> |
      And   I click Agree
      And   I click the next button
      And   I click save button
      Then I should get teh successful message

      Examples:
        | firstName | lastName | email                |
        | John      | Doe      | john123@gmail.com    |
        | Walter    | White    | walterwhite@gmail.co |




