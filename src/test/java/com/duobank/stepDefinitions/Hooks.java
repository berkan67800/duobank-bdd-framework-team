package com.duobank.stepDefinitions;

import com.duobank.utilities.ConfigReader;
import com.duobank.utilities.DBUtils;
import com.duobank.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

import static io.restassured.RestAssured.baseURI;

public class Hooks {


    @Before ("not @api")
    public void setupScenario(){

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigReader.getProperty("url"));


    }

    @BeforeAll
    public static void setupDb(){

        DBUtils.createConnection();
        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";

    }
    //
    @AfterAll
    public static void tearDb(){
        DBUtils.close();
    }


    @After ("not @api")
    public void tearDownScenario(Scenario scenario){

        if(scenario.isFailed()) {
            byte[] screenshotFile = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotFile, "image/png", "screenshotOfFailure");

        }

        Driver.quitDriver();

    }



}
