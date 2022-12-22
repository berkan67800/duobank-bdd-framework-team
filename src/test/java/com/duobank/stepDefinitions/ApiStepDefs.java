package com.duobank.stepDefinitions;

import com.duobank.utilities.ConfigReader;
import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import io.restassured.common.mapper.TypeRef;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;

import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiStepDefs {
    RequestSpecification requestSpecification;
    Response response;

    @Given("the base URI is initialized and headers are {string} {string} and {string} {string}")
    public void the_base_uri_is_initialized_and_headers_are_and(String key, String value, String key2, String value2) {



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


    String token;
    @Then("the status code should be {int} and body should be as in the table")
    public void the_status_code_should_be_and_body_should_be_as_in_the_table(Integer statusCode, List<List<String>> dataTable) {
        
        Map<String,Object> map =response.then().log().all().
                assertThat().
                statusCode(equalTo(statusCode)).extract().as(Map.class);

        SoftAssertions softAssert = new SoftAssertions();
        for (List<String> tableEntry:dataTable) {
            softAssert.assertThat(map.get(tableEntry.get(0)).equals(tableEntry.get(1)));
        }
        softAssert.assertAll();

        if(map.containsKey("token")){
            token = (String) map.get("token");
        }




    }



    @Given("Given I login with existing  email and password")

        public void given_i_login_with_existing_and() {



        requestSpecification = given().log().all().
                header("Accept", "application/json").
                header("Content-Type", "application/json").
                body(Map.of("email",ConfigReader.getProperty("email"),
                            "password",ConfigReader.getProperty("password")
                ));

    }


    @Given("headers are {string} {string}  {string} {string} and user credentials randomly generated")
    public void headers_are_and_user_credentials_randomly_generated(String key, String value, String key2, String value2) {
        Faker faker = new Faker();

        requestSpecification = given().log().all().
                header(key, value).
                header(key2, value2).
                body(Map.of("first_name",faker.name().firstName(),
                            "last_name",faker.name().lastName(),
                            "email",faker.internet().emailAddress(),
                            "password",faker.internet().password()
                        ));


    }

    @When("I send a request to {string}")
    public void iSendARequestTo(String endpoint) {

        switch(endpoint) {
            case "/register.php":
                response = requestSpecification.when().log().all().
                        post(endpoint);
                break;
            case "/login.php":
                response = requestSpecification.when().log().all().
                        post(endpoint);
                break;
            case "/getmortagage.php":
                response = requestSpecification.header("Authorization", token).when().log().all().
                        get(endpoint);
                break;
            case "/mortagagedetails.php":
                JsonPath jsonPath = response.jsonPath();
                Integer id = jsonPath.getInt("mortagage_applications[0].id");
                response = requestSpecification.body(Map.of("id",id)).when().log().all().
                        post(endpoint);
                break;
        }
    }

    @Then("the mortgage application should have keys as in the table")
    public void the_mortgage_application_should_have_keys_as_in_the_table(List<String> expected) {
        Map responseBody = response.as(new TypeRef<Map<String, Object>>() {});
        List<Map<String,Object>> mortagage_applications = (List<Map<String, Object>>) responseBody.get("mortagage_applications");


        List<String> actual = new ArrayList<>(mortagage_applications.get(0).keySet());

        System.out.println(actual);
        System.out.println(expected);
        Assert.assertEquals(expected,actual);
    }

    @And("for the first mortgage application details the single_application should contain keys  in the table")
    public void forTheFirstMortgageApplicationDetailsTheSingle_applicationShouldHaveKeysAsInTheTable(List<String> keys) {


        Map responseBody = response.then().log().all().extract().as(new TypeRef<Map<String, Object>>() {});
        Map <String,Object> single_application = (Map<String, Object>) responseBody.get("single_application");
        List actual = new ArrayList(single_application.keySet());

        SoftAssertions softAssertions = new SoftAssertions();

        for (String key : keys) {
            softAssertions.assertThat(actual.contains(key));
        }
       softAssertions.assertAll();
    }
}
    
