package com.duobank.pages;

import com.duobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

    public SignUpPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }




    @FindBy(id = "inputfirstname4")
    public WebElement firstNameField;

    @FindBy(id = "inputlastname4")
    public WebElement lastNameField;

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "exampleInputPassword1")
    public WebElement passwordField;

    @FindBy(id = "register")
    public WebElement signUpButton;





}
