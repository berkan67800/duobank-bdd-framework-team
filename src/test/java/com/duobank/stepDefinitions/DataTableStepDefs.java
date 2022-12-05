package com.duobank.stepDefinitions;

import com.duobank.pages.MortgageApplicationPage;
import io.cucumber.java.en.When;

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




}
