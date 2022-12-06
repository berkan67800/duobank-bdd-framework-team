@sprint4
Feature: Database scenarios





     Scenario: Create User DB to UI Data Mapping

      Given I create a new user with the following information in the database
      | username   | first | last   | email               | password |
      | tom.cruise | Tom   | Cruise | tomcruise@gmail.com | tommy123 |
      And I navigate to the Login page
      Then I should be able to login with created account and land on Loan Application page
      And  I should be able to see the same full name that I signed up with
      And I delete the account information in the database



     @db_only
     Scenario: Verify database Users table column names

       When I send a query to retrieve column names for users table
       Then The column names should be the following
         | id          |
         | email       |
         | password    |
         | first_name  |
         | last_name   |
         | phone       |
         | image       |
         | type        |
         | created_at  |
         | modified_at |
         | zone_id     |
         | church_id   |
         | country_id  |
         | active      |



  @db_only
  Scenario: Verify business rule related to user table email field
    When I send a request to retrieve all duplicates
    Then The email column should not contain any duplicates