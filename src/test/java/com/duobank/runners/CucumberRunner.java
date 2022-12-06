package com.duobank.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@CucumberOptions(


        tags = "@sprint4",
        features = "src/test/resources",
        glue = "com/duobank/stepDefinitions",
        stepNotifications = true,
        plugin = {
                "pretty",
                "html:target/cucumber-built-in-report/report.html",
                "json:target/jsonReport.json",
                "rerun:target/failedScenarioList.txt"
        }
        //, dryRun = true  // to generate step definition snippets without running the test


)
@RunWith(Cucumber.class)
public class CucumberRunner {
}
