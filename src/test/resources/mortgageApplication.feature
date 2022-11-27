@mortgageApplication @regression
Feature:  Mortgage Application feature



  Background: Common steps for all scenarios
    Given I navigate to the Login page
    Then I enter valid login credentials
    And I click Mortgage Application option from the left menu


  Scenario: Enter valid Estimated Purchase Price and valid Down Payment Amount
    When I enter Estimated Purchase Price as $ 4000 and Down Payment Amount as $ 300
    Then I should be able to see the correct result in the loan amount text bar


  Scenario: Enter valid Estimated Purchase Price and valid Down Payment Percentage
    When I enter Estimated Purchase Price as $ 8000 and Down Payment Percentage as % 10
    Then I should be able to see the correct result in the loan amount text bar


