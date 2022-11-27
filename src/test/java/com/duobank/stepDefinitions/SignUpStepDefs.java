package com.duobank.stepDefinitions;

import com.duobank.pages.DashBoardPage;
import com.duobank.pages.LoginPage;
import com.duobank.pages.SignUpPage;
import com.duobank.utilities.Driver;
import com.duobank.utilities.SeleniumUtils;
import com.github.javafaker.Faker;
import com.mysql.cj.log.Log;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SignUpStepDefs {

    @Given("I navigate to the Sign up page")
    public void i_navigate_to_the_sign_up_page() {
        new LoginPage().signUpLink.click();
    }

    String firstName;
    String lastName;
    String email;
    String password;
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
}
