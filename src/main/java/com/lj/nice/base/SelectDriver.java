package com.lj.nice.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectDriver {
    public WebDriver driverName(String browser) {
        if(browser.equalsIgnoreCase("fireFox"))
        {
            System.setProperty("webdriver.firefox.marionette", "D:\\\\java\\\\geckodriver\\\\geckodriver.exe");
            return new FirefoxDriver();
        }else{
            //D:\javaenvirement\webdriver
            System.setProperty("webdriver.chrome.driver","D:\\\\javaenvirement\\\\webdriver\\\\chromedriver.exe");
            return new ChromeDriver();
        }

    }
}
