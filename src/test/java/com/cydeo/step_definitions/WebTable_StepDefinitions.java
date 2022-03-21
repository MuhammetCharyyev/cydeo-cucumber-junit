package com.cydeo.step_definitions;

import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebTable_StepDefinitions {

    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();
    //object from WebTableLoginPage to identify below steps for login

    @Given("user is on the login page of web table app")
    public void user_is_on_the_login_page_of_web_table_app() {
        Driver.getDriver().get(ConfigurationReader.getProperty("webTableUrl"));
    }

    @When("user enters username {string}")
    public void user_enters_username(String string) {
        webTableLoginPage.inputUsername.sendKeys(string);
    }

    @When("user enters password {string}")
    public void user_enters_password(String string) {
        webTableLoginPage.inputPassword.sendKeys(string);
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        webTableLoginPage.loginBtn.click();
    }

    @When("user enters username {string} password {string} and login")
    public void user_enters_username_password_and_login(String username, String passw) {
        webTableLoginPage.inputUsername.sendKeys(username);
        webTableLoginPage.inputPassword.sendKeys(passw);
        webTableLoginPage.loginBtn.click();
    }

    @Then("user should see url contains order")
    public void user_should_see_url_contains_order() {
        BrowserUtils.verifyUrlContains("orders");
        //called method from BrowserUtils
    }



}
