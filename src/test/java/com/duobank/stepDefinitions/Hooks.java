package com.duobank.stepDefinitions;

import com.duobank.utilities.ConfigReader;
import com.duobank.utilities.DBUtils;
import com.duobank.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class Hooks {


    @Before ("not @db_only")
    public void setupScenario(){

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigReader.getProperty("url"));


    }

    @BeforeAll
    public static void setupDb(){
        DBUtils.createConnection();
    }
    //
    @AfterAll
    public static void tearDb(){
        DBUtils.close();
    }


    @After ("not @db_only")
    public void tearDownScenario(Scenario scenario){

        if(scenario.isFailed()) {
            byte[] screenshotFile = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotFile, "image/png", "screenshotOfFailure");

        }

        Driver.quitDriver();

    }



}
