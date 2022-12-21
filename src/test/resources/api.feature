Feature: API Rest Assured code BDD


  @api
  Scenario: Register a new user

    Given the base URI is initialized and headers are "Accept" "application/json" and "Content-Type" "application/json"
    When I send a POST request to "/register.php"
    Then the status code should be 200 and "message" body should be  "You have successfully registered."


  @api
  Scenario: Login a user with existing credentials.

    Given Given I login with existing  "email" and "password"
    When  I send a request to "/login.php"
    Then  the success code should be 200 and and "message" body should be  "You have successfully logged in."