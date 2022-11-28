package com.duobank.pages;

import com.duobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MortgageApplicationPage {

    public MortgageApplicationPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//label[@for='realtor1']")
    public WebElement yesForRealtor;

    @FindBy(xpath = "//label[@for='realtor2']")
    public WebElement NoForRealtor;


    @FindBy(xpath = "//input[@id='realtorinfo']")
    public WebElement infoOfRealtorField;

    @FindBy(xpath = "//label[@for='loanofficer1']")
    public WebElement yesForLoanOfficer;


    @FindBy(xpath = "//label[@for='loanofficer2']")
    public WebElement NoForLoanOfficer;


    @FindBy(xpath = "//span[@id='select2-purpose_loan-th-container']")
    public WebElement purposeOfLoanContainer;

    @FindBy(xpath = "//li[@id='select2-purpose_loan-th-result-cda8-Purchase a Home']")
    public WebElement purchaseAHomeOption;


    @FindBy(xpath = "//div[@class='loanamount']")
    public WebElement loanAmountCalculator;

    @FindBy(id = "estimatedprice")
    public WebElement estimatedPurchasePriceField;

    @FindBy(id = "downpayment")
    public WebElement downPaymentAmount;

    @FindBy(name ="down_payment_percent")
    public WebElement downPaymentPercentage;

    @FindBy(xpath ="//span[@id='select2-src_down_payment-cf-container']")
    public WebElement sourceOfDownpaymentContainer;

    @FindBy(xpath =" //span[@id='select2-src_down_payment-dp-container']")
    public WebElement sourceOfDownpayment;

    @FindBy(xpath ="//li[@id='select2-src_down_payment-dp-result-nmar-Other type of Down Payment']")
    public WebElement thirdOption;

    @FindBy(xpath = "//a[normalize-space()='Next']")
    public WebElement nextButton;

    @FindBy(xpath = "//div[@class='borrower']")
    public WebElement borrowerInfoDIV;

    @FindBy(id = "b_firstName")
    public WebElement borrowerFistNameField;

    @FindBy(id = "b_lastName")
    public WebElement borrowerLastNameField;

    @FindBy(id = "b_email")
    public WebElement borrowerEmailField;

    @FindBy(id = "b_ssn")
    public WebElement borrowerSSNField;

    @FindBy(id = "b_cell")
    public WebElement borrowerCellField;

    @FindBy(id = "b_marital")
    public WebElement borrowerMaritalStatusField;

    @FindBy(id = "b_dob")
    public WebElement borrowerDOBField;


    @FindBy(xpath = "//li[@class='current']//span[@class='d-block']")
    public WebElement applicationWizardCurrentStep;










}
