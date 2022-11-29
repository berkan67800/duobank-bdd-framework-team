@mortgageApplication @regression
Feature:  Mortgage Application feature



  Background: Common steps for all scenarios
    Given I navigate to the Login page
    Then I enter valid login credentials
    And I click Mortgage Application option from the left menu


  Scenario: Fill the preapproval form
    When  I add valid information to the preapproval form
    And   I click the next button
    Then  I should be able to see Personal Information text


  Scenario: Fill the preapproval form with negative information
    When  I enter invalid information to the preapproval form
    And   I click the next button
    Then  I should not be able to navigate to the Personal Information step


  Scenario: Enter valid Estimated Purchase Price and valid Down Payment Amount
    When I enter Estimated Purchase Price as $ 4000 and Down Payment Amount as $ 300
    Then I should be able to see the correct result in the loan amount text bar


  Scenario: Enter valid Estimated Purchase Price and valid Down Payment Percentage
    When I enter Estimated Purchase Price as $ 8000 and Down Payment Percentage as % 10
    Then I should be able to see the correct result in the loan amount text bar


  Scenario: Fill the Personal Information form
    When  I add valid information to the preapproval form
    And   I click the next button
    And   I enter valid information to the Personal Information form
    And   I click the next button
    Then  I should be able to navigate to the Expenses step


  Scenario: Fill the Personal Information form with invalid information
    When  I add valid information to the preapproval form
    And   I click the next button
    When  I enter invalid information to the Personal Information form
    And   I click the next button
    Then  I should not be able to navigate to the Expenses step

  Scenario: Fill the Expenses step
    Given I add valid information to the preapproval form
    And   I click the next button
    When  I enter valid information to the Personal Information form
    And   I click the next button
    And   I should be able to navigate to the Expenses step
    When  I fill the Expenses step and click next button
    Then  I should be able to land Employment and Income step

  Scenario: Fill the Employment and Income step
    Given I add valid information to the preapproval form
    And   I click the next button
    When  I enter valid information to the Personal Information form
    And   I click the next button
    And   I should be able to navigate to the Expenses step
    When  I fill the Expenses step and click next button
    And   I should be able to land Employment and Income step
    And   I fill the Employment and Income step with valid information
    And   I click the next button
    Then  I should be able to land Credit Report step

   Scenario: Fill the Employment and Income step with invalid information
     Given I add valid information to the preapproval form
     And   I click the next button
     When  I enter valid information to the Personal Information form
     And   I click the next button
     And   I should be able to navigate to the Expenses step
     When  I fill the Expenses step and click next button
     And   I should be able to land Employment and Income step
     And   I fill the Employment and Income step with invalid information
     And   I click the next button
     Then  I should not be able to land Credit Report step
