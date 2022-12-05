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


