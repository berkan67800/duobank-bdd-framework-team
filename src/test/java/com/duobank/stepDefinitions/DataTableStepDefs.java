package com.duobank.stepDefinitions;

import com.duobank.pages.MortgageApplicationPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class DataTableStepDefs {

    @When("I add the following info to the preapproval form")
    public void i_add_the_following_info_to_the_preapproval_form(List<Map<String,String>> dataTable) {

        MortgageApplicationPage mortgageApplicationPage = new MortgageApplicationPage();
        mortgageApplicationPage.realtorInfoField.sendKeys(dataTable.get(0).get("realtorName"));
        mortgageApplicationPage.estimatedPurchasePriceField.sendKeys(dataTable.get(0).get("purchasePrice"));
        mortgageApplicationPage.downPaymentAmount.sendKeys(dataTable.get(0).get("downPayment"));

    }


    @When("I fill the Employment and Income step following valid information")
    public void i_fill_the_employment_and_income_step_following_valid_information(List<Map<String,String>> dataTable) throws InterruptedException {
        MortgageApplicationPage mortgageApplicationPage = new MortgageApplicationPage();
        mortgageApplicationPage.employerName.sendKeys(dataTable.get(0).get("employerName"));
        mortgageApplicationPage.employerPosition.sendKeys(dataTable.get(0).get("position"));
        mortgageApplicationPage.employerCity.sendKeys(dataTable.get(0).get("city"));
        Thread.sleep(2000);
        Select state = new Select(mortgageApplicationPage.employerState);
        state.selectByVisibleText("AM");
        Thread.sleep(2000);
        mortgageApplicationPage.employerStartDate.sendKeys(dataTable.get(0).get("startDate"));
        mortgageApplicationPage.grossMonthlyIncome.sendKeys(dataTable.get(0).get("grossMonthlyIncome"));
        Select incomeSource = new Select(mortgageApplicationPage.additionalIncome);
        incomeSource.selectByVisibleText("Other Types of Income");
        //incomeSource.selectByVisibleText(dataTable.get(0).get("incomeSource"));
        Thread.sleep(2000);
        mortgageApplicationPage.incomeAmount.sendKeys(dataTable.get(0).get("amount"));
        Thread.sleep(2000);




    }

}
