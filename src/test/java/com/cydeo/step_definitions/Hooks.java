package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

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
    public void teardownScenario(){

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
