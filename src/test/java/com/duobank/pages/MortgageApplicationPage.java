package com.duobank.pages;

import com.duobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MortgageApplicationPage {

    public MortgageApplicationPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//div[@class='loanamount']")
    public WebElement loanAmountCalculator;

    @FindBy(id = "estimatedprice")
    public WebElement estimatedPurchasePriceField;

    @FindBy(id = "downpayment")
    public WebElement downPaymentAmount;

    @FindBy(name ="down_payment_percent")
    public WebElement downPaymentPercentage;


}
