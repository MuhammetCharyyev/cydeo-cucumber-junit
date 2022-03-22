package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.OrderPage;
import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Order_StepDefinitions {

    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();
    //called object to implement login
    BasePage basePage =new BasePage();
    //called object to implement methods for orders
    OrderPage orderPage = new OrderPage();
    //called object to call product dropDown

    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
//getting page using url from config.props
        Driver.getDriver().get(ConfigurationReader.getProperty("webTableUrl"));

        //login method from WebTableLoginPage
        //Calling our login method to log in to web table app
        webTableLoginPage.login();

        //clicking to "order" link to go order page
        basePage.order.click();
    }

    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {

        Select select = new Select(orderPage.productDropDown);
        //select productDropdown menu from orderPage
        select.selectByVisibleText(string);
        //select when the text of dedicated element will be visible

    }
//    @When("user enters quantity {string}")
//    public void user_enters_quantity(String string) {
//
//    }

    @And("user enters quantity {int}")
    public void userEntersQuantity(int arg0) {
        //accepting int arg and sending it using sendKeys
   //since senKeys only accept String we need to concat with "" or send String.valueOf(int)
        //orderPage.inputQuantity.sendKeys(arg0+"");
        //OR
       // orderPage.inputQuantity.clear();//this will delete whatever the input box has
        orderPage.inputQuantity.sendKeys(Keys.BACK_SPACE);
        //imitating pressing Backspace button to delete everything in input box,
        // work better than 'clear', but less accurate

        orderPage.inputQuantity.sendKeys(String.valueOf(arg0));
        //we code this snippet with int to enter argument inside ()
        //better to code it as String arg
    }

    @When("user enters costumer name {string}")
    public void user_enters_costumer_name(String string) {
orderPage.inputName.sendKeys(string);
    }

    @When("user enters street {string}")
    public void user_enters_street(String string) {
orderPage.inputStreet.sendKeys(string);
    }

    @When("user enters city {string}")
    public void user_enters_city(String string) {
orderPage.inputCity.sendKeys(string);
    }

    @When("user enters state {string}")
    public void user_enters_state(String string) {
orderPage.inputState.sendKeys(string);
    }

    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
orderPage.inputZip.sendKeys(string);
    }

    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String expectedCardType) {
//    List<WebElement> cardTypes = orderPage.cardType;
//    //assign it to 'List' as we need to get list of webelements
//        for (WebElement eachCard : cardTypes) {//iterate each card from the list
//            if(eachCard.getAttribute("value").equalsIgnoreCase(expectedCardType));
//            //getAttribute ("locator") will find location of required field
////.equals will check if the location matches to expected element as we indicated in 'features'
//            eachCard.click();//click it when found
//        }
//    }
        BrowserUtils.clickRadioBtn(orderPage.cardType, expectedCardType);
        //called method from 'BrowserUtils' instead of above

    }

    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String string) {
      orderPage.cardNoInput.sendKeys(string);
    }

    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String string) {
       orderPage.cardExpInput.sendKeys(string);
    }
    @When("user enters process order button")
    public void user_enters_process_order_button() {
        orderPage.processOrderBtn.click();
    }
    @Then("user should see {string} in first row of the web table")
    public void user_should_see_in_first_row_of_the_web_table(String string) {

    }


}
