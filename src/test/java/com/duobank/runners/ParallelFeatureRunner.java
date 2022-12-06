package com.duobank.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions(


        features = "src/test/resources/parallelFeatures",
        glue = "com/duobank/stepDefinitions",
        stepNotifications = true,
        plugin = {
                "pretty",
                "html:target/cucumber-built-in-report/report.html",
                "json:target/jsonReport.json"
        }


)
@RunWith(Cucumber.class)
public class ParallelFeatureRunner {
}
