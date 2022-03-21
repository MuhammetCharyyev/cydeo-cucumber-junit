package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * in this class we'll store WebElements common to all pages
 */

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='View all orders']")
    public WebElement vewAllOrders;

    @FindBy (xpath = "//button[.='View all products']")
    public WebElement vewAllProducts;

    @FindBy (xpath = "//button[.='Order']")
    public WebElement order;

    @FindBy (xpath = "//button[.='Logout']")
    public WebElement logoutBtn;

}
