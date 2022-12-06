package com.duobank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions(

        features = "@target/failedScenarioList.txt",
        glue = "com/duobank/stepDefinitions",
        stepNotifications = true,
        plugin = {

                "html:target/cucumber-built-in-report/failedReport.html",  // generates a built-in cucumber html report

        }



)
@RunWith(Cucumber.class)
public class FailedScenarioRunner {
}