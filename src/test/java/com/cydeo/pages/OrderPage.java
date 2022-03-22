package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OrderPage extends BasePage {//this class will inherit methods from BasPage as well

    public OrderPage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (name = "product")//finding dropdown 'product' menu
    public WebElement productDropDown;

    //finding each element of inputs in 'Make an Order'
    @FindBy (name = "quantity")
    public WebElement inputQuantity;
    @FindBy (name = "name")
    public WebElement inputName;
    @FindBy (name = "street")
    public WebElement inputStreet;
    @FindBy (name = "city")
    public WebElement inputCity;
    @FindBy (name = "state")
    public WebElement inputState;
    @FindBy (name = "zip")
    public WebElement inputZip;
    @FindBy (name = "card")
    public List<WebElement> cardType;//'List' because it will return with list of webelements
    @FindBy(name = "cardNo")
    public WebElement cardNoInput;
    @FindBy(name = "cardExp")
    public WebElement cardExpInput;
    @FindBy(css = "button[type='submit']")
    public WebElement processOrderBtn;






}
