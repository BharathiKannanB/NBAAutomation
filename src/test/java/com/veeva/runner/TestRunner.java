package com.veeva.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

/**
 * The TestRunner class is used to run Cucumber tests in TestNG.
 * It extends AbstractTestNGCucumberTests to provide TestNG compatibility.
 * The class also defines a DataProvider for parallel execution of test scenarios.
 */
public class TestRunner extends AbstractTestNGCucumberTests {


    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
