package com.testnaukri.tests.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.testnaukri.tests.stepdefinitions"},
        plugin = {"pretty", "json:target/cucumber-report.json", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @DataProvider
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
