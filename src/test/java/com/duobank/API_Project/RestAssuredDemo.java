package com.duobank.API_Project;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredDemo {

    RequestSpecification requestSpecification;
    Response response;

    @Test
    public void givenStepDefinition() {

        // Set the base URL

        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
        // basePath = common path after base URL

        requestSpecification = given().log().all().
                header("Accept", "application/json").
                header("Content-Type", "application/json").
                body("{ \"first_name\": \"Tomi\",\n" +
                        "\"last_name\": \"Hil\",\n" +
                        "\"email\": \"tomhil1@inbox.ru\",\n" +
                        "\"password\": \"tomhil\"\n" +
                        "\n" +
                        "}");
    }

     @Test
        public void whenStepDefinition() {

             response = requestSpecification.when().log().all().
                    post("/register.php");
        }

        @Test
        public void thenStepDefinition() {

            response.then().log().all().
                    assertThat().
                    statusCode(equalTo(200));

        }
    }



