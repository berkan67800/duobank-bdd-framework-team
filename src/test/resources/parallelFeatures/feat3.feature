Feature: Test Parallel execution on DB 3

  Scenario: Create User UI To DB Data Mapping
    Given I navigate to the Sign up page
    When I enter the following info to sign up
      | first  | last  | email             | password  |
      | Mathew | Lord  | lordmat@gmail.com | mat123    |
    Then I should be able to login with created account and land on Loan Application page
    And  I should be able to see the same full name that I signed up with
    Then I retrieve the information for created account from the database and verify the data mapping
