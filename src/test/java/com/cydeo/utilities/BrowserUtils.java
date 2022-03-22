package com.cydeo.utilities;

/*
In this class only general utility methods that are not related to some specific page
 */

import io.cucumber.java.an.E;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    /*
    This method will accept int (in seconds) and execute Thread.sleep
    for given duration
     */

    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
        }
    }

     /*
    This method accepts 3 arguments.
    Arg1: webdriver
    Arg2: expectedInUrl : for verify if the url contains given String.
        - If condition matches, will break loop.
    Arg3: expectedInTitle to be compared against actualTitle
     */

    public static void switchWindowAndVerify(String expectedInURL, String expectedTitle) {

        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowsHandles) {

            Driver.getDriver().switchTo().window(each);

            System.out.println("Current URL is : " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInURL)) {
                break;
            }
        }

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    /*
 This method accepts a String "expectedTitle" and Asserts if it is true
  */
    public static void verifyTitle(String expectedTitle) {

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);

    }

    public static void verifyUrlContains(String expectedInUrl) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInUrl));
        //method to verify if current URL contains expected value
    }

    /**
     * This method will accept a dropdown as WebElement and return all the options text
     * in a list of String
     *
     * @param dropdownElement
     * @return
     */

    public static List<String> dropdownAsString(WebElement dropdownElement) {
        //creating a method for getting list of webelements and convert it to list of String
        //accept WebElement in 'Select' section as argument and return List<String>

        Select select = new Select(dropdownElement);
        //to deal with dropdowns we need 'Select' library

        List<WebElement> actualOptionsAsWebElement = select.getOptions();
        //return with list of WebElements

        List<String> actualOptionsAsString = new ArrayList<>();

        for (WebElement each : actualOptionsAsWebElement) {//iterate each web element of dropdown
            actualOptionsAsString.add(each.getText());
            //adding text of each webelement to the ArrList
        }
             return actualOptionsAsString;
    }

    /**
     * this method will accept group radio btns as a list of WebElement
     * it will loop through the List and click to the radio btn with provided attributeValue
     * @param radioBtns
     * @param attributeValue
     */

    public static void clickRadioBtn(List<WebElement> radioBtns, String attributeValue){
        //create a method to click required radio button with 2 args

        for (WebElement each : radioBtns) {//iterate each radio button from the list
        if(each.getAttribute("value").equalsIgnoreCase(attributeValue));
        //getAttribute ("value") will find location of value of required field
//.equals will check if the location matches to expected element as we indicated in 'features'
        each.click();//click it when found
    }
}


}

  /*
    1. Create a new class called BrowserUtils
    2. Create a method to make Task1 logic re-usable
    3. When method is called, it should switch window and verify title.


    Method info:
    • Name: switchWindowAndVerify
    • Return type: void
    • Arg1: WebDriver
    • Arg2: String expectedInUrl
    • Arg3: String expectedTitle
     */
