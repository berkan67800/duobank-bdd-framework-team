package com.duobank.stepDefinitions;

import com.duobank.pages.MortgageApplicationPage;
import io.cucumber.java.en.When;
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


}
