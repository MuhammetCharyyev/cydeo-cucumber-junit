package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class GoogleStepDefinitions {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    //object from GoogleSearchPage class to call searchBox method

    @When("User types apple and click enter")
    public void user_types_apple_and_click_enter() {
        googleSearchPage.searchBox.sendKeys("apple"+ Keys.ENTER);
        //called method from GoogleSearchPage with finding Google search box
        // putting there our search word and push enter
    }

    @Then("User sees apple in the google title")
    public void user_sees_apple_in_the_google_title() {
        String expectedTitle = "apple - Google Search";
        String actualTitle = Driver.getDriver().getTitle();
        //verify if the title is as expected after finding 'apple'
        Assert.assertEquals("Title is not as expected", expectedTitle, actualTitle);
        //a bit another order than in TestNG
    }

    @When("User in on Google search page")
    public void user_in_on_google_search_page() {
        Driver.getDriver().get("https://www.google.com");
    }

    @Then("User should see title is Google")
    public void user_should_see_title_is_google() {
        String expectedTitle = "Google";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        Driver.closeDriver();
    }

}
