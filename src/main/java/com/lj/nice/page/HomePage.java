package com.lj.nice.page;


import com.lj.nice.base.DriverBase;
import com.lj.nice.util.GetByLocator;
import org.openqa.selenium.WebElement;


public class HomePage extends BasePage {
    public HomePage(DriverBase driver){
        super(driver);
    }
    /**
     * 获取点击登陆element
     * */
    public WebElement getLoginElement(){
        return element(GetByLocator.getLocator("login"));
    }
    /**
     * 获取实战element
     * */
    public WebElement getCodingElement(){
        return getChildrenElement(GetByLocator.getLocator("tophead"),GetByLocator.getLocator("coding"));
    }

    /**
     * 获取用户名信息element
     * */
    public WebElement getUserNameElement(){
        action(element(GetByLocator.getLocator("header")));
        return element(GetByLocator.getLocator("nameInfo"));
    }

}
