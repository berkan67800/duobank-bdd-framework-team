package com.duobank.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiStepDefs {
    RequestSpecification requestSpecification;
    Response response;

    @Given("the base URI is initialized and headers are {string} {string} and {string} {string}")
    public void the_base_uri_is_initialized_and_headers_are_and(String key, String value, String key2, String value2) {
        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";


        requestSpecification = given().log().all().
                header(key, value).
                header(key2, value2).
                body("{ \"first_name\": \"Ton\",\n" +
                        "\"last_name\": \"Kil\",\n" +
                        "\"email\": \"tomhil4@inbox.ru\",\n" +
                        "\"password\": \"tomhil\"\n" +
                        "\n" +
                        "}");
    }
    @When("I send a POST request to {string}")
    public void i_send_a_post_request_to(String endpoint) {
        response = requestSpecification.when().log().all().
                post(endpoint);
    }
    @Then("the status code should be {int} and {string} body should be  {string}")
    public void the_status_code_should_be_and_body_should_be(Integer statuscode, String key, String value) {

        response.then().log().all().
                assertThat().
                statusCode(equalTo(statuscode)).
                body(key, equalTo(value));
    }



    @Given("Given I login with existing  {string} and {string}")

        public void given_i_login_with_existing_and(String email, String password) {
        email = "tomhil4@inbox.ru";
        password = "tomhil";

        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
        requestSpecification = given().log().all().
                header("Accept", "application/json").
                header("Content-Type", "application/json").
                body("{ \n" +
                        "\"email\": \"tomhil4@inbox.ru\",\n" +
                        "\"password\": \"tomhil\"\n" +
                        "}");

    }
    @When("I send a request to {string}")
    public void i_send_a_request_to(String endpoint) {
        response = requestSpecification.when().log().all().
                post(endpoint);
    }
    @Then("the success code should be {int} and and {string} body should be  {string}")
    public void the_success_code_should_be_and_and_body_should_be(Integer success, String key, String value) {
        response.then().log().all().
                assertThat().
                statusCode(equalTo(success)).
                body(key, equalTo(value));

    }




 /*       RequestSpecification requestSpecification;
        Response response;

        @Given("the base URI is initialized and header is {string} {string}")
        public void the_base_uri_is_initialized_and_header_is(String key, String value) {

            baseURI = "https://api.github.com";

            requestSpecification = given().
                    header(key, value);

        }
        @When("I send a GET request to {string}")
        public void i_send_a_get_request_to(String endpoint) {

            response = requestSpecification.
                    when().log().all().
                    get(endpoint);

        }
        @Then("the status code should be {int} and {string} value in the body should be  {string}")
        public void the_status_code_should_be_and_value_should_be(Integer statusCode, String key, String value) {
            response.
                    then().log().all().
                    assertThat().
                    statusCode(equalTo(statusCode)).
                    body(key, equalTo(value));

        }  */
    }
    
