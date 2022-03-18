package com.cydeo.step_definitions;

import io.cucumber.java.en.Then;

import java.util.List;

public class DataTable_StepDefinitions {

    @Then("user should see fruits I Like")
    public void user_should_see_fruits_i_like(List<String> fruits) {
     //we apply List<String> because we need place all fruits name from dataTable.feature
        System.out.println(fruits); //[kiwi, banana, orange, mango, pamelo, apple]
        System.out.println(fruits.get(1)); //banana
    }

}
