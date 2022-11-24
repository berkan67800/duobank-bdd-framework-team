package com.duobank.pages;

import com.duobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "exampleInputEmail1")
    public WebElement emailField;

    @FindBy(id = "exampleInputPassword1")
    public WebElement passwordField;

    @FindBy(name = "login")
    public WebElement loginButton;


}
