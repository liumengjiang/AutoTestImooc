package com.lj.nice.page;

import com.lj.nice.base.DriverBase;
import com.lj.nice.util.GetByLocator;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    public LoginPage(DriverBase driverBase) {
        super(driverBase);
        // TODO Auto-generated constructor stub
    }
    /*
     * 获取用户名输入框Element
     *
     * */
    public WebElement getUserElement() {
        //找到properties中的userName变量
        return element(GetByLocator.getLocator("userName"));
    }

    /*
     * 获取密码输入框Element
     *
     * */
    public WebElement getPasswordElement() {
        return element(GetByLocator.getLocator("userPass"));
    }

    /*
     * 获取登录按钮输入框
     *
     * */
    public WebElement getLoginButtonElement() {
        return element(GetByLocator.getLocator("buttonElement"));
    }

    /*
     * 获取自动登录Element
     *
     * */
    public WebElement getAutoLoginElement() {
        return element(GetByLocator.getLocator("autoSigin"));
    }

}
