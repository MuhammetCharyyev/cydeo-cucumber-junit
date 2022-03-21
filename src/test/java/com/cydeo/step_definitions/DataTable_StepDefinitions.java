package com.cydeo.step_definitions;

import com.cydeo.pages.DropdownsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import com.google.common.collect.Table;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DataTable_StepDefinitions {

    @Then("user should see fruits I Like")
    public void user_should_see_fruits_i_like(List<String> fruits) {
     //we apply List<String> because we need place all fruits name from dataTable.feature
        System.out.println(fruits); //[kiwi, banana, orange, mango, pamelo, apple]
        System.out.println(fruits.get(1)); //banana
    }

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("https://practice");
    }

    DropdownsPage dropdownsPage = new DropdownsPage();
    //creating object to call method from DropdownsPage
    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedMonths) {
//        Select select = new Select(dropdownsPage.monthDropdown);
//        //to deal with dropdowns we need 'Select' library
//        List<WebElement> actualOptionsAsWebElement = select.getOptions();
//        //return with list of WebElements
//
//        List<String > actualOptionsAsString = new ArrayList<>();
//
//        for (WebElement each : actualOptionsAsWebElement) {//iterate each web element of dropdown
//            actualOptionsAsString.add(each.getText());
//            //adding text of each webelement to the ArrList
//        }


        List<String> actualMonths  = BrowserUtils.dropdownAsString(dropdownsPage.monthDropdown);
//this method called from BrowserUtils to replace above one
        Assert.assertEquals(expectedMonths, actualMonths);
//assert will check size of the list first, if it's matching it will check content 1 by 1

    }

}
