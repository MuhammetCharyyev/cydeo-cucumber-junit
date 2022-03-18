package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * In this class we'll be able to pass pre- & post-conditions to each scenario and step
 */

public class Hooks {
    @Before (order = 1)//'@Before' import from io.cucumber.java not from Junit
    //giving 'order =1' you make prioritization to test, by default it will go by alphabet order
    public void setupScenario(){
        System.out.println("===Setting up browser using cucumber @Before===");
    }

    @Before (value = "@login", order = 2)//giving 'order =2' you make prioritization to test
    // this Before is created for separate Scenario,
    // annotation "@login" we determined in login.feature
    public void setupScenarioForLogin(){
        System.out.println("===this will only apply to scenario with @login tag===");
    }

    @Before (value = "@db", order = 0)// this Before is created for separate Scenario,
    // annotation "@db" we determine in login.feature
    //'order = 0' will implement this method on first turn,by default it will go by alphabet order
    public void setupScenarioForDatabaseScenario(){
        System.out.println("===this will only apply to scenario with @db tag===");
    }


    @After //'@After' import from io.cucumber.java not from Junit
    public void teardownScenario(Scenario scenario){//Scenario come from cucumber-Java

        //scenario.isFailed() -> if scenario fails this method will return with TRUE
        //i.e. our screenshot will be executed
        if (scenario.isFailed()){
            byte [] screenshot = ((TakesScreenshot)Driver.getDriver()).
                    getScreenshotAs(OutputType.BYTES);
            //basically we code to our Driver make a screenshot and take this method from
            // TakesScreenshot library (getScreenshotAs(OutputType.BYTES)) by downcasting
            //use array of bytes to make screenshot, as it's clear image
            scenario.attach(screenshot, "image/png", scenario.getName());
            //apply operation to attach screenshot:
// 1. byte [] (screenshot here), 2.mediatype as String ("image/png" here),
// 3. String name (scenario.getName() here)
        }



        Driver.closeDriver();
//        System.out.println("===Closing browser using cucumber @After===");
//        System.out.println("===Scenario ended/ Take screenshot if failed!===");
    }

    @BeforeStep
    public void setupStep(){
        System.out.println("------->Applying setup using @BeforeStep<-------");
    }

    @AfterStep
    public void afterStep(){
        System.out.println("------->Applying tearDown using @AfterStep<-------");
    }

}
