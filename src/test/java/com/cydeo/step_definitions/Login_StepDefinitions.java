package com.cydeo.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_StepDefinitions {
//copied below from our console after running the CucesRunner class
    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        System.out.println("User enters librarian username");
        //entered sout manually after deleting unnecessary 2 lines
    }
    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        System.out.println("User enters librarian username");
        //entered sout manually after deleting unnecessary 2 lines
    }
    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        System.out.println("User should see the dashboard");
        //entered sout manually after deleting unnecessary 2 lines 
    }

}
