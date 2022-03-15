package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions",
        dryRun = false,
        //dryRun turns of the running step_definitions
        //dryRun = true -> do not run my step_definitions but only check  if any step is missing snippet
        //dryRun = false -> turn off dryRun and our code will run as expected
        tags = "@Regression"//named it by custom, as you want, only make sense where you place it
        //can be @smoke, @librarian, @student or @admin which are in login.feature
        //you can even "@librarian or @student" will execute 2 scenarios
        //'or' here is like || in Java, if any true then execute
        //@Regression is placed at the top of login.feature to execute whole code
        //if we place it at the top only one Scenario of login.feature
        // then it will execute only this Scenario
)

public class CucesRunner {
}
