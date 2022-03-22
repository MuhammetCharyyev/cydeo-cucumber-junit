package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//this class for failed tests, rerun only failed tests according to the rerun.txt report
@CucumberOptions(
        glue = "com/cydeo/step_definitions",
        features = "@target/rerun.txt"
//path of the location of rerun.txt file where our reports of failed test will be store

)

public class FailedTestRunner {
}
