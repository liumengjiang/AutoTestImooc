package com.lj.nice.business;

import com.lj.nice.base.DriverBase;
import com.lj.nice.handle.HomePageHandle;

public class HomePagePro {
    public HomePageHandle hph;
    public HomePagePro(DriverBase driver){
        hph =new HomePageHandle(driver);
    }
    /**
     * 点击登陆按钮
     * */
    public void clickLoginButton(){
        hph.clickLogin();
    }
    /**
     * 点击实战按钮
     * */
    public void clickCodingLink(){
        hph.clickCoding();
    }
    /**
     * 根据用户名判断登陆信息是否正确
     * */
    public Boolean AssertLogin(String username){
        if(hph.getUserName().equals(username)){
            return true;
        }
        return false;
    }

}
