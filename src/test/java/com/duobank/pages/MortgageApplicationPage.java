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

    @FindBy(id = "realtorinfo")
    public WebElement realtorInfoField;


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

    @FindBy(xpath = "//label[@for='coborrower1']")
    public WebElement yesForCoBorrower;

    @FindBy(xpath = "//span[@id='select2-b_suffix-container']")
    public WebElement selectSuffixField;

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


    @FindBy(id = "c_firstName")
    public WebElement coBorrowerFistNameField;

    @FindBy(id = "c_lastName")
    public WebElement coBorrowerLastNameField;

    @FindBy(id = "c_email")
    public WebElement coBorrowerEmailField;

    @FindBy(id = "c_ssn")
    public WebElement coBorrowerSSNField;

    @FindBy(id = "c_cell")
    public WebElement coBorrowerCellField;

    @FindBy(id = "c_marital")
    public WebElement coBorrowerMaritalStatusField;

    @FindBy(id = "c_dob")
    public WebElement coBorrowerDOBField;

    @FindBy(xpath = "//a[normalize-space()='Next']")
    public WebElement personalINformationNextButton;

    @FindBy(xpath = "//h6[normalize-space()='Current Monthly Housing Expenses']")
    public WebElement currentMonthlyHousingExpensesText;


    @FindBy(xpath = "//div[@class='co-borrower']//h6[@class='py-50']")
    public WebElement coBorroweInformationText;

    @FindBy(xpath = "//input[@id='monthlyrentalpayment']")
    public WebElement monthlyRentalPaymentField;

    @FindBy(xpath = "//h6[normalize-space()='Borrower Employment Information']")
    public WebElement borrowerEmploymentInfoText;

    @FindBy(xpath = "//input[@id='employername1']")
    public WebElement employerName;

    @FindBy(xpath = "//input[@id='position1']")
    public WebElement employerPosition;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement employerCity;

    @FindBy(xpath = "//select[@id='state1']")
    public WebElement employerState;

    @FindBy(xpath = "//input[@id='start_date1']")
    public WebElement employerStartDate;

    @FindBy(xpath = "//input[@id='grossmonthlyincome']")
    public WebElement grossMonthlyIncome;

    @FindBy(xpath = "//select[@id='incomesource1']")
    public WebElement additionalIncome;

    @FindBy(xpath = "//input[@id='amount1']")
    public WebElement incomeAmount;

    @FindBy(xpath = "//p[contains(text(),'Would you like to order a credit report to help us')]")
    public WebElement messageForCreditReport;

    @FindBy(xpath = "//fieldset[@id='steps-uid-0-p-4']//h6[@class='pb-50'][normalize-space()='PreApproval Inquiry']")
    public WebElement preapprovalInquiryText;


}
