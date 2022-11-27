package com.duobank.stepDefinitions;

import com.duobank.pages.DashBoardPage;
import com.duobank.pages.MortgageApplicationPage;
import com.duobank.utilities.SeleniumUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MortgageApplicationStepDefs {

    MortgageApplicationPage mortgageApplicationPage = new MortgageApplicationPage();

    @Then("I click Mortgage Application option from the left menu")
    public void i_click_mortgage_application_option_from_the_left_menu() {
            new DashBoardPage().mortgageApplicationLink.click();
    }
    @When("I enter Estimated Purchase Price as $ {int} and Down Payment Amount as $ {int}")
    public void i_enter_estimated_purchase_price_as_$_and_down_payment_amount_as_$(Integer purchasePrice, Integer downPaymentAmount) {

        mortgageApplicationPage.estimatedPurchasePriceField.sendKeys(String.valueOf(purchasePrice));
        mortgageApplicationPage.downPaymentAmount.sendKeys(String.valueOf(downPaymentAmount));


    }

    @When("I enter Estimated Purchase Price as $ {int} and Down Payment Percentage as % {int}")
    public void i_enter_estimated_purchase_price_as_$_and_down_payment_percentage_as(Integer purchasePrice, Integer downPaymentPercentage) {
        mortgageApplicationPage.estimatedPurchasePriceField.sendKeys(String.valueOf(purchasePrice));
        mortgageApplicationPage.downPaymentPercentage.sendKeys(String.valueOf(downPaymentPercentage));
    }
    @Then("I should be able to see the correct result in the loan amount text bar")
    public void i_should_be_able_to_see_the_correct_result_in_the_loan_amount_text_bar() {

        int estimatedPurchasePrice = Integer.parseInt(mortgageApplicationPage.estimatedPurchasePriceField.getAttribute("value").replaceAll("[^0-9]",""));
        int downPaymentAmount = Integer.parseInt(mortgageApplicationPage.downPaymentAmount.getAttribute("value").replaceAll("[^0-9]",""));
        int actualResult = Integer.parseInt(mortgageApplicationPage.loanAmountCalculator.getText().replaceAll("[^0-9]",""));
        int estimatedResult = estimatedPurchasePrice-(downPaymentAmount);

        Assert.assertEquals(estimatedResult,actualResult);

    }
}
