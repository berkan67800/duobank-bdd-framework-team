#Feature: Sign Up feature

#
#  Background: Common steps for all scenarios
#    Given I navigate to the homepage
#    And I click on sign up link
#
#
#
#  Scenario: Sign up with random valid info
#    When I enter valid random info to sign up
#    Then I should be able to login and land on Welcome page
#    And  I should be able to see the same full name that I signed up with


#  Scenario: Sign up with invalid info
#    When I enter invalid random info to sign up
#    Then I should not be able to login
#
#
#
#  Scenario: Sign up no info
#    When I enter no info to sign up
#    Then I should not be able to login
#
#
#  Scenario: Sign up with datatable info
#    When I enter the following info to sign up
#      | username    | first  | last | email                | password      |
#      | donald.duck | Donald | Duck | donaldduck@gmail.com | donaldduck123 |
#    Then I should be able to login and land on Welcome page
#    And  I should be able to see the same full name that I signed up with
#
#   @outline
#  Scenario Outline: Sign up with valid info from examples tables
#    When I enter the following info to sign up
#      | username | first   | last   | email   | password |
#      | <USER>   | <FIRST> | <LAST> | <EMAIL> | <PASS>   |
#    Then I should be able to login and land on Welcome page
#    And  I should be able to see the same full name that I signed up with
#
#    Examples:
#      | USER                       | FIRST  | LAST  | EMAIL                 | PASS          |
#      | donald.duck                | Donald | Duck  | donaldduck@gmail.com  | donaldduck123 |
#      | mickey.mouse               | Mickey | Mouse | mm@gmail.com          | mm123         |
#      | minnie.mouse               | Minnie | Mouse | mmi@gmail.com         | mmi123        |
#      | goofy.dog                  | Goofy  | Dog   | goofydogk@gmail.com   | goofyk123     |
#      | <script>alert(12)</script> | Goofy  | Dog   | goofydogk12@gmail.com | goofyk123     |
#


