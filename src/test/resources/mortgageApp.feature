@regression

  Feature: Filling the mortgage application form

    Scenario: Fill the preapproval details
      Given I navigate the mortgage application page
      When  I fill the preapproval details
      And   I click the next button
      Then  I should be able to navigate Personal Information step