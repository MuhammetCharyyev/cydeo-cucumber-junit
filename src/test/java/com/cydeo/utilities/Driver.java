package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
//creating a private constructor, so we are closing access to object from outside the class

    private Driver() {
    }

    //make element WebDriver private  coz we want to close access from outside the class
    //make it static coz we'll use in a static method
  //  private static WebDriver driver;//value is null by default

    private static InheritableThreadLocal<WebDriver> driverPool=new InheritableThreadLocal();
    //created object to use when we execute several parallel threads in the same time,
    // replace ordinary 'driver' as above
    //will basically implement several drivers from pool



    //create re-usable utility method which will return same driver instance when we'll call
    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
//driverPool.get replaces 'driver'
            String browserType = ConfigurationReader.getProperty("browser");
            //if it's null I want to create my wish browser
            // and it will return with browser type, get it from config.prop as value.
            // We can control what browser is opened from outside our code

            //depending on browserType that will be return from config.prop file,
            // switch statement will determine the case and open matching browser
            switch (browserType) {//generate 'switch' to indicate all browsers type to choose
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());//.set run the driver
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver()) ;
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driverPool.set (new OperaDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driverPool.set (new EdgeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                default:
                    WebDriverManager.safaridriver().setup();
                    driverPool.set  (new SafariDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        }
        return driverPool.get();//if not null then return with current 'driver'
    }

    //method to make sure our driver value always 'null' after using 'quite()' method,
    // basically restart browser after 'quit'
    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();//this line will terminate existing session, value will not even be null
            driverPool.remove();//assign value back to null
        }

    }
}
/* Another option of above:


    public static WebDriver get() {
        if (driver == null) {
            String browser = ConfigurationReader.get("browser");

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;

                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("OS doesn't support IE browser");
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("OS doesn't support Edge browser");
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("OS doesn't support Safari browser");
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;

            }


        }
        return driver;
    }
    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }

*/
