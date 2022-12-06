package com.duobank.stepDefinitions;

import com.duobank.pages.DashBoardPage;
import com.duobank.pages.LoginPage;
import com.duobank.pages.SignUpPage;
import com.duobank.utilities.DBUtils;
import com.duobank.utilities.Driver;
import com.duobank.utilities.SeleniumUtils;
import com.github.javafaker.Faker;
import com.mysql.cj.log.Log;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.digest.DigestUtils;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class SignUpStepDefs {

    String firstName;
    String lastName;
    String email;
    String password;

    @Given("I navigate to the Sign up page")
    public void i_navigate_to_the_sign_up_page() {
        new LoginPage().signUpLink.click();
    }


    @When("I enter valid random info to sign up")
    public void i_enter_valid_random_info_to_sign_up() {

        Faker faker = new Faker();

        firstName=faker.name().firstName();
        lastName=faker.name().lastName();
        email=faker.internet().emailAddress();
        password=faker.internet().password();

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.firstNameField.sendKeys(firstName);
        signUpPage.lastNameField.sendKeys(lastName);
        signUpPage.emailField.sendKeys(email);
        signUpPage.passwordField.sendKeys(password);
        signUpPage.signUpButton.click();

        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Registration Successfull"));



}
    @Then("I should be able to login with created account and land on Loan Application page")
    public void i_should_be_able_to_login_with_created_account_and_land_on_loan_application_page() {

        SeleniumUtils.waitForUrlContains("http://qa-duobank.us-east-2.elasticbeanstalk.com/index.php",6);


        LoginPage loginPage = new LoginPage();
        loginPage.emailField.sendKeys(email);
        loginPage.passwordField.sendKeys(password);
        loginPage.loginButton.click();


        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php"));
    }
    @Then("I should be able to see the same full name that I signed up with")
    public void i_should_be_able_to_see_the_same_full_name_that_i_signed_up_with() {

        String actualResult = new DashBoardPage().fullNameText.getText();
        Assert.assertEquals(firstName+" "+lastName,actualResult);
    }

    @When("I enter the following info to sign up")
    public void i_enter_the_following_info_to_sign_up(List<Map<String,String>> dataTable) {

        Map<String, String> map = dataTable.get(0);

        firstName=map.get("first");
        lastName=map.get("last");
        email=map.get("email");
        password=map.get("password");

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.firstNameField.sendKeys(map.get("first"));
        signUpPage.lastNameField.sendKeys(map.get("last"));
        signUpPage.emailField.sendKeys(map.get("email"));
        signUpPage.passwordField.sendKeys(map.get("password"));
        signUpPage.signUpButton.click();

        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Registration Successfull"));
    }
    @Then("I retrieve the information for created account from the database and verify the data mapping")
    public void i_retrieve_the_information_from_the_database_and_verify_the_data_mapping() throws SQLException, InterruptedException {


        String query = "select * from tbl_user where email='"+email+"'";
        Thread.sleep(1000);
        List<Map<String, Object>> dbresult = DBUtils.getQueryResultAsListOfMaps(query);


        Map<String, Object> userInfoRow = dbresult.get(0);
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(userInfoRow.get("first_name")).isEqualTo(firstName);
        softAssertions.assertThat(userInfoRow.get("last_name")).isEqualTo(lastName);
        softAssertions.assertThat(((String)(userInfoRow.get("email"))).toLowerCase()).isEqualTo(email);
        String passwordMD5 = DigestUtils.md5Hex(password);
        softAssertions.assertThat(userInfoRow.get("password")).isEqualTo(passwordMD5);

        String createdAt=userInfoRow.get("created_at").toString().split(" ")[0];
        //softAssertions.assertThat(createdAt).isEqualTo(LocalDate.now());

        DBUtils.executeUpdate("DELETE from tbl_user where email='"+email+"'");

        softAssertions.assertAll();

    }

    @Given("I create a new user with the following information in the database")
    public void i_create_a_new_user_with_the_following_information_in_the_database(List<Map<String,String>> dataTable) throws SQLException {

        Map<String, String> map = dataTable.get(0);

        firstName=map.get("first");
        lastName=map.get("last");
        email=map.get("email");
        password=map.get("password");
        String passwordMD5 = DigestUtils.md5Hex(password);


        String query = "INSERT INTO tbl_user (email, password, first_name, last_name,phone,image,type,created_at,modified_at,zone_id,church_id,country_id,active)\n" +
                "VALUES ('"+email+"', '"+passwordMD5+"', '"+firstName+"', '"+lastName+"','555-444-33-22','','0',NOW(),NOW(),'0','0','0','1');";
        DBUtils.executeUpdate(query);
    }
    @Then("I delete the account information in the database")
    public void i_delete_the_account_information_in_the_database() throws SQLException {

         DBUtils.executeUpdate("DELETE from tbl_user where email='"+email+"';");
    }
}
