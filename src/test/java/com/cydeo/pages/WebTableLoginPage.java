package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTableLoginPage {

    public WebTableLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "username")
    public WebElement inputUsername;
    @FindBy(name = "password")
    public WebElement inputPassword;
    @FindBy(xpath = "//button[.='Login']")
    public WebElement loginBtn;

    /**
    Username: Test
     Password: Tester
     */

    public void login(){ //create unified method 'login' with indication objects of this class
        this.inputUsername.sendKeys("Test");
        this.inputPassword.sendKeys("Tester");
        this.loginBtn.click();
    }

    /**
     * This method will accept two args and login
     * @param username
     * @param password
     */
    public void login (String username, String password){
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        loginBtn.click();
    }

    /**
     * This method will login using credentials fron config.props
     */
    public void loginWithConfig(){
        inputUsername.sendKeys(ConfigurationReader.getProperty("webTableUsername"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("webTablePassword"));
        loginBtn.click();
    }

}
