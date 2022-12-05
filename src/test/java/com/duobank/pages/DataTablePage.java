package com.duobank.pages;

import com.duobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataTablePage {

    public DataTablePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//label[@for='creditreport2']")
    public WebElement noForCreditReport;

    @FindBy(xpath = "//a[normalize-space()='Next']")
    public WebElement nextButton;

    @FindBy(xpath = "//input[@id='eConsentdeclarerFirstName']")
    public WebElement eConsentFirstName;

    @FindBy(xpath = "//input[@id='eConsentdeclarerLastName']")
    public WebElement eConsentLastName;

    @FindBy(xpath = "//input[@id='eConsentdeclarerEmail']")
    public WebElement eConcentEmail;

    @FindBy(xpath = "//label[normalize-space()='Agree']")
    public WebElement agreeRadioBtn;

    //@FindBy(xpath = "//label[normalize-space()='Agree']")
    //public WebElement

    //@FindBy(xpath = "//label[normalize-space()='Agree']")
    //public WebElement











}
