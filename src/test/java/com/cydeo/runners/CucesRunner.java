package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions",
        dryRun = true
        //dryRun turns of the running step_definitions
        //dryRun = true -> do not run my step_definitions but only check  if any step is missing snippet
        //dryRun = false ->  run my step_definitions but only check  if any step is missing snippet
)

public class CucesRunner {
}
