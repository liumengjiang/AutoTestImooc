package com.lj.nice.handle;

import com.lj.nice.base.DriverBase;
import com.lj.nice.page.HomePage;

public class HomePageHandle {
    public DriverBase driver;
    public HomePage hp;
    public HomePageHandle(DriverBase driver){
        this.driver = driver;
        hp = new HomePage(driver);
    }
    /**
     * 点击登陆按钮
     * */
    public void clickLogin(){
        hp.click(hp.getLoginElement());
    }

    /**
     * 点击实战按钮
     * */
    public void clickCoding(){
        hp.click(hp.getCodingElement());
    }
    /**
     * 获取用户名
     * */
    public String getUserName(){
        String username = hp.getText(hp.getUserNameElement());
        return username;
    }
}