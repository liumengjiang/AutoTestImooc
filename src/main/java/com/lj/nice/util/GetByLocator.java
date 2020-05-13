package com.lj.nice.util;

import org.openqa.selenium.By;

public class GetByLocator {
    public static By getLocator(String key) {
        ProUtil proUtil=new ProUtil("element.properties");
        String locator=proUtil.getPro(key);
        String locatorType=locator.split(">")[0];
        String locatorValue=locator.split(">")[1];
        if(locatorType.equals("id"))
        {
            return By.id(locatorValue);
        }else if(locatorType.equals("name"))
        {
            return By.name(locatorValue);
        }else if(locatorType.equals("className"))
        {
            return By.className(locatorValue);
        }else if(locatorType.equals("linkText"))
        {
            return By.linkText(locatorValue);
        }else if(locatorType.equals("tagName")) {
            return By.tagName(locatorValue);
        }else {
            return By.xpath(locatorValue);
        }



    }

}
