package com.duobank.stepDefinitions;

import com.duobank.pages.LoginPage;
import com.duobank.utilities.ConfigReader;
import com.duobank.utilities.Driver;
import com.duobank.utilities.SeleniumUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MortgageAppStepDefs {

    @Given("I navigate the mortgage application page")
    public void i_navigate_the_mortgage_application_page() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.emailField.sendKeys(ConfigReader.getProperty("email"));
        loginPage.passwordField.sendKeys(ConfigReader.getProperty("password"));
        loginPage.loginButton.click();
      /*  //WebDriver driver = new ChromeDriver();

        Alert alert = WebDriver.
        //driver.get("http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php");

        //driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();

        driver.switchTo( ).alert( ).accept(); */

    }

    @When("I fill the preapproval details")
    public void i_fill_the_preapproval_details() {

    }

    @When("I click the next button")
    public void i_click_the_next_button() {

    }

    @Then("I should be able to navigate Personal Information step")
    public void i_should_be_able_to_navigate_personal_information_step() {

    }

}
