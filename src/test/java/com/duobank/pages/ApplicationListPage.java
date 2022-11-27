package com.duobank.pages;

import com.duobank.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class ApplicationListPage {

    public ApplicationListPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
