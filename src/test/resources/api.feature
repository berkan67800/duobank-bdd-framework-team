Feature: API Rest Assured code BDD


  @api
  Scenario: Register a new user by using random valid credentials.

    Given headers are "Accept" "application/json"  "Content-Type" "application/json" and user credentials randomly generated
    When I send a request to "/register.php"
    Then the status code should be 200 and body should be as in the table
      | message | You have successfully registered. |
      | success | 1                                 |
      | status  | 201                               |


    @UI
  Scenario: Register a new user by using random valid credentials and log in through the UI login page

    Given headers are "Accept" "application/json"  "Content-Type" "application/json" and user credentials randomly generated
    When I send a request to "/register.php"
    Then the status code should be 200 and body should be as in the table
      | message | You have successfully registered. |
      | success | 1                                 |
      | status  | 201                               |
    Then I should be able to login with created account



  @api
  Scenario: Register a new user by existing user credentials

    Given headers are "Accept" "application/json" and "Content-Type" "application/json"
    When I send a request to "/register.php"
    Then the status code should be 200 and body should be as in the table
      | message | This E-mail already in use! |
      | status  | 422                         |
      | success | 0                           |


  @api
  Scenario: Login a user with existing credentials.

    Given I login with existing  email and password
    When  I send a request to "/login.php"
    Then the status code should be 200 and body should be as in the table
      | message | You have successfully logged in. |
      | success | 1                                |

  @api
  Scenario: Login a user with credentials from json file.

    Given I login with json file content from "src/test/java/com/duobank/jsonFile/loginCredentials.json"
    When  I send a request to "/login.php"
    Then the status code should be 200 and body should be as in the table
      | message | You have successfully logged in. |
      | success | 1                                |

  @api
  Scenario: Login a user with existing credentials and get mortgage applications belonging to a logged in user

    Given I login with existing  email and password
    When  I send a request to "/login.php"
    Then the status code should be 200 and body should be as in the table
      | message | You have successfully logged in. |
    And I send a request to "/getmortagage.php"
    Then the status code should be 200 and body should be as in the table
      | success | 1   |
      | status  | 200 |
    Then the mortgage application should have keys as in the table
      | id                |
      | b_firstName       |
      | b_lastName        |
      | b_middleName      |
      | total_loan_amount |

  @api
  Scenario: Login a user with existing credentials and get mortgage applications belonging to a logged in user with invalid token

    Given I login with existing  email and password
    When  I send a request to "/login.php"
    Then the status code should be 200 and body should be as in the table
      | message | You have successfully logged in. |
    And I enter invalid token
    And I send a request to "/getmortagage.php"
    Then the status code should be 200 and body should be as in the table
      | success | 0            |
      | status  | 401          |
      | message | Unauthorized |


@api
  Scenario: Login a user with existing credentials and a specific mortgage application details for a logged in user

    Given I login with existing  email and password
    When  I send a request to "/login.php"
    Then the status code should be 200 and body should be as in the table
      | message | You have successfully logged in. |
    And I send a request to "/getmortagage.php"
    Then the status code should be 200 and body should be as in the table
      | success | 1   |
      | status  | 200 |
    And I send a request to "/mortagagedetails.php"
    Then for the first mortgage application details the single_application should contain keys  in the table
      | id                            |
      | realtor_status                |
      | realtor_info                  |
      | loan_officer_status           |
      | purpose_loan                  |
      | est_purchase_price            |
      | down_payment                  |
      | down_payment_percent          |
      | total_loan_amount             |
      | src_down_payment              |
      | add_fund_available            |
      | apply_co_borrower             |
      | b_firstName                   |
      | b_middleName                  |
      | b_lastName                    |
      | b_suffix                      |
      | b_email                       |
      | b_dob                         |
      | b_ssn                         |
      | b_marital                     |
      | b_cell                        |
      | b_home                        |
  Then I store the response body as json file

  @api
  Scenario: Mortgage application details contains a specific key and value

    Given I login with existing  email and password
    When  I send a request to "/login.php"
    Then the status code should be 200 and body should be as in the table
      | message | You have successfully logged in. |
    And I send a request to "/getmortagage.php"
    Then the status code should be 200 and body should be as in the table
      | success | 1   |
      | status  | 200 |
    And In result body the key "b_firstName"  has not null value


  @api
  Scenario: Send an invalid request to the endpoint

    Given I login with existing  email and password
    When  I send a GET request to "/login.php"
    Then the status code should be 403 and body should be as in the table
      | message | Page Not Found! |
      | success | 0               |







