package com.duobank.pages;

import com.duobank.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class MortgageApplicationPage {

    public MortgageApplicationPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

}