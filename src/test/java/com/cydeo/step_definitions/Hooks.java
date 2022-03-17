package com.cydeo.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

/**
 * In this class we'll be able to pass pre- & post-conditions to each scenario and step
 */

public class Hooks {
    @Before //'@Before' import from io.cucumber.java not from Junit
    public void setupScenario(){
        System.out.println("===Setting up browser using cucumber @Before===");
    }

    @After //'@After' import from io.cucumber.java not from Junit
    public void teardownScenario(){
        System.out.println("===Closing browser using cucumber @After===");
    }

}
