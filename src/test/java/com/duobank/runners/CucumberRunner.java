package com.duobank.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@CucumberOptions(

        tags = "@datatable", //@regression",
        features = "src/test/resources",
        glue = "com/duobank/stepDefinitions",
        stepNotifications = true,
        plugin = {

                "html:target/cucumber-built-in-report/report.html",  // generates a built-in cucumber html report

        }
        //, dryRun = true  // to generate step definition snippets without running the test


)
@RunWith(Cucumber.class)
public class CucumberRunner {
}
