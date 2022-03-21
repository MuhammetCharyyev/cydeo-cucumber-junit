package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends BasePage {//this class will inherit methods from BasPage as well

    public OrderPage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }




}
