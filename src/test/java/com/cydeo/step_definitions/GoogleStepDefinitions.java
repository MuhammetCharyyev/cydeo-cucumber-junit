package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class GoogleStepDefinitions {

    @When("User types apple and click enter")
    public void user_types_apple_and_click_enter() {

    }
    @Then("User sees apple in the google title")
    public void user_sees_apple_in_the_google_title() {

    }

    @When("User in on Google search page")
    public void user_in_on_google_search_page() {
        Driver.getDriver().get("https://www.google.com");
    }

    @Then("User should see title is Google")
    public void user_should_see_title_is_google() {
        String expectedTitle = "Google";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

        Driver.closeDriver();
    }

}
