package com.duobank.stepDefinitions;

import com.duobank.pages.DashBoardPage;
import com.duobank.pages.MortgageApplicationPage;
import com.duobank.utilities.Driver;
import com.duobank.utilities.SeleniumUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class MortgageApplicationStepDefs {

    MortgageApplicationPage mortgageApplicationPage = new MortgageApplicationPage();
    Faker faker = new Faker();

    @Then("I click Mortgage Application option from the left menu")
    public void i_click_mortgage_application_option_from_the_left_menu() {

        SeleniumUtils.jsClick(new DashBoardPage().mortgageApplicationLink);
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

    @Then("I should be able to see Personal Information text")
    public void i_should_be_able_to_see_personal_information_text() {
        Assert.assertTrue(mortgageApplicationPage.coBorroweInformationText.isDisplayed());
    }


    @When("I enter invalid information to the preapproval form")
    public void i_enter_invalid_information_to_the_preapproval_form() throws InterruptedException {
        MortgageApplicationPage mortgageApplicationPage = new MortgageApplicationPage();
        mortgageApplicationPage.infoOfRealtorField.sendKeys("＜script＞alert(12)＜/script＞");
        mortgageApplicationPage.estimatedPurchasePriceField.sendKeys("600000");
        Thread.sleep(700);
        mortgageApplicationPage.downPaymentAmount.sendKeys("60000");
    }
    @Then("I should not be able to navigate to the Personal Information step")
    public void i_should_not_be_able_to_navigate_to_the_next_step() {
        Assert.assertTrue(!(mortgageApplicationPage.borrowerInfoDIV.isDisplayed()));
    }

    @When("I enter valid information to the Personal Information form")
    public void i_enter_valid_information_to_the_personal_information_form() {
        mortgageApplicationPage.borrowerFistNameField.sendKeys(faker.name().firstName());
        mortgageApplicationPage.borrowerLastNameField.sendKeys(faker.name().lastName());
        mortgageApplicationPage.borrowerEmailField.sendKeys(faker.internet().emailAddress());
        mortgageApplicationPage.borrowerDOBField.sendKeys("12121990");
        mortgageApplicationPage.borrowerSSNField.sendKeys("123456789");
        Select maritalStatus = new Select(mortgageApplicationPage.borrowerMaritalStatusField);
        maritalStatus.selectByVisibleText("Married");
        mortgageApplicationPage.borrowerCellField.sendKeys("555555555");

 }
    @Then("I should be able to navigate to the Expenses step")
    public void i_should_be_able_to_navigate_to_the_expenses_step() {
         Assert.assertTrue(SeleniumUtils.elementExists(mortgageApplicationPage.applicationWizardCurrentStep,1));
    }


    @When("I enter invalid information to the Personal Information form")
    public void i_enter_invalid_information_to_the_personal_information_form() throws InterruptedException {
          mortgageApplicationPage.yesForCoBorrower.click();
          mortgageApplicationPage.borrowerFistNameField.sendKeys("00000");
          mortgageApplicationPage.borrowerLastNameField.sendKeys("00000");
          mortgageApplicationPage.borrowerEmailField.sendKeys("000@000");
          mortgageApplicationPage.borrowerSSNField.sendKeys("000-00-0000");
          mortgageApplicationPage.borrowerDOBField.sendKeys("00000000");

          Select maritalStatus = new Select(mortgageApplicationPage.borrowerMaritalStatusField);
          maritalStatus.selectByVisibleText("Divorced");

          mortgageApplicationPage.borrowerCellField.sendKeys("000-00-0000");
          mortgageApplicationPage.coBorrowerFistNameField.sendKeys("99999");
          mortgageApplicationPage.coBorrowerLastNameField.sendKeys("22222");
          mortgageApplicationPage.coBorrowerEmailField.sendKeys("000@000");
          mortgageApplicationPage.coBorrowerDOBField.sendKeys("02022000");
          mortgageApplicationPage.coBorrowerSSNField.sendKeys("000-00-0000");

          Select maritalStatus2 = new Select(mortgageApplicationPage.coBorrowerMaritalStatusField);
          maritalStatus2.selectByVisibleText("Separated");

          mortgageApplicationPage.coBorrowerCellField.sendKeys("000-000-0000");

    }

    @Then("I should not be able to navigate to the Expenses step")
    public void i_should_not_be_able_to_navigate_to_the_expenses_step()  {
        Assert.assertFalse(mortgageApplicationPage.currentMonthlyHousingExpensesText.isDisplayed());
    }


    @When("I fill the Expenses step and click next button")
    public void i_fill_the_expenses_step_and_click_next_button() {
        mortgageApplicationPage.monthlyRentalPaymentField.sendKeys("3000");
        mortgageApplicationPage.nextButton.click();

    }
    @Then("I should be able to land Employment and Income step")
    public void i_should_be_able_to_land_employment_and_income_step() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Co-Borrower Employment Information"));

    }



}
