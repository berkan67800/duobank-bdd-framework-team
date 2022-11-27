package com.duobank.stepDefinitions;

import com.duobank.pages.DashBoardPage;
import com.duobank.pages.MortgageApplicationPage;
import com.duobank.utilities.Driver;
import com.duobank.utilities.SeleniumUtils;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

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


    @When("I add valid information to the preapproval form")
    public void i_add_valid_information_to_the_preapproval_form() throws InterruptedException {
        MortgageApplicationPage mortgageApplicationPage = new MortgageApplicationPage();
        mortgageApplicationPage.NoForRealtor.click();
        Thread.sleep(700);
        mortgageApplicationPage.NoForLoanOfficer.click();
        mortgageApplicationPage.estimatedPurchasePriceField.sendKeys("600000");
        Thread.sleep(700);
        mortgageApplicationPage.downPaymentAmount.sendKeys("60000");

    }
    @When("I click the next button")
    public void i_click_the_next_button() {
        mortgageApplicationPage.nextButton.click();
    }
    @Then("I should be able to see {string} text")
    public void i_should_be_able_to_see_text(String string) {

        Assert.assertTrue(mortgageApplicationPage.personalInformationText.isDisplayed());
    }



}
