package com.duobank.stepDefinitions;

import com.duobank.pages.DataTablePage;
import com.duobank.pages.MortgageApplicationPage;
import com.duobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class ScenarioOutlineStepDefs {


    @When("I enter the following info to Personal Information form")
    public void i_enter_the_following_info_to_personal_information_form(List<Map<String, String>> dataTable) {

        MortgageApplicationPage mortgageApplicationPage = new MortgageApplicationPage();

        Map<String, String> map = dataTable.get(0);
        System.out.println(dataTable.get(0));

        mortgageApplicationPage.borrowerFistNameField.sendKeys(map.get("firstName"));
        mortgageApplicationPage.borrowerLastNameField.sendKeys(map.get("lastName"));
        mortgageApplicationPage.borrowerEmailField.sendKeys(map.get("email"));
        mortgageApplicationPage.borrowerDOBField.sendKeys(map.get("dateOfBirth"));
        mortgageApplicationPage.borrowerSSNField.sendKeys(map.get("SSN"));
        Select maritalStatus = new Select(mortgageApplicationPage.borrowerMaritalStatusField);
        maritalStatus.selectByVisibleText(map.get("maritalStatus"));
        mortgageApplicationPage.borrowerCellField.sendKeys(map.get("cellPhone"));
    }

    @Then("I add the following info to eConsent page")
    public void i_add_the_following_info_to_e_consent_page(List<Map<String, String>> dataTable) {
        DataTablePage dataTablePage = new DataTablePage();

        Map<String, String> map = dataTable.get(0);
        System.out.println(dataTable.get(0));

        dataTablePage.eConsentFirstName.sendKeys(map.get("firstName"));
        dataTablePage.eConsentLastName.sendKeys(map.get("lastName"));
        dataTablePage.eConcentEmail.sendKeys(map.get("email"));

    }
    @Then("I click Agree")
    public void i_click_agree() {
        DataTablePage dataTablePage = new DataTablePage();
        dataTablePage.agreeRadioBtn.click();

    }

    @Then("I click save button")
    public void i_click_save_button() {
        DataTablePage dataTablePage = new DataTablePage();
        dataTablePage.saveBtn.click();
    }
    @Then("I should get teh successful message")
    public void i_should_get_teh_successful_message() {
        DataTablePage dataTablePage = new DataTablePage();
        Assert.assertTrue(dataTablePage.successfulMessage.isDisplayed());

    }








}
