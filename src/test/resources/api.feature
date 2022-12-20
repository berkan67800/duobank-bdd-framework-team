Feature: API Rest Assured code BDD


  @api
  Scenario: Post new user

    Given the base URI is initialized and headers are "Accept" "application/json" and "Content-Type" "application/json"
    When I send a POST request to "/register.php"
    Then the status code should be 200 and "message" body should be  "You have successfully registered."