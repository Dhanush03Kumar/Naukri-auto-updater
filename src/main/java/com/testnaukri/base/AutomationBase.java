package com.testnaukri.base;

import com.testnaukri.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;




public class AutomationBase {

    protected WebDriver driver;


    public void setUp(){


        String browser = ConfigReader.getProperty("browser").toLowerCase();
        System.out.println("Hello!");
        System.out.println("Starting testing on: "+browser);

        switch (browser){
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable notifications");
                driver=new ChromeDriver(options);
                break;

            case "firefox":
                //Add code to initialize firefox driver
                break;

            case "edge":
                //Add code to initialize edge driver
                break;

            default:
                throw new IllegalArgumentException("Invalid browser value : "+browser);
        }

        String url = ConfigReader.getProperty("url");
        driver.get(url);


    }



    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

    public WebDriver getDriver(){
        return driver;
    }
}


