package com.duobank.stepDefinitions;

import com.duobank.pages.LoginPage;
import com.duobank.utilities.ConfigReader;
import com.duobank.utilities.Driver;
import com.mysql.cj.log.Log;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    @Given("I navigate to the Login page")
    public void i_navigate_to_the_login_page() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }
    @When("I enter valid login credentials")
    public void i_enter_valid_login_credentials() {

        LoginPage loginPage = new LoginPage();
        loginPage.emailField.sendKeys(ConfigReader.getProperty("email"));
        loginPage.passwordField.sendKeys(ConfigReader.getProperty("password"));
        loginPage.loginButton.click();

    }
    @Then("I should be able to login and land on Loan Application page")
    public void i_should_be_able_to_login_and_land_on_loan_application_page() {
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php", Driver.getDriver().getCurrentUrl());
    }

    @When("I enter login credentials as {string} and {string}")
    public void i_enter_login_credentials_as_and(String email, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.emailField.sendKeys(email);
        loginPage.passwordField.sendKeys(password);
        loginPage.loginButton.click();
    }

}
