package com.lj.nice.testcase;

import com.lj.nice.base.DriverBase;
import com.lj.nice.business.HomePagePro;
import com.lj.nice.business.LoginPro;
import com.lj.nice.util.HandleCookie;
import com.lj.nice.util.ProUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SuiteTestLogin extends CaseBase{
    public DriverBase driver;
    public LoginPro loginPro;
    public ProUtil proUtil;
    public HomePagePro homePagePro;
    public HandleCookie handleCookie;

    //相当于构造方法
    @BeforeClass
    public void beforeClass() {
        this.driver = InitDriverBase("chrome");
        proUtil = new ProUtil("loginTest.properties");
        handleCookie = new HandleCookie(driver);
        //设置系统响应时间为10秒钟
        driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPro = new LoginPro(driver);
        homePagePro = new HomePagePro(driver);
        driver.get(proUtil.getPro("url"));
        driver.getWindowMax();
    }

    @Test
    @Parameters({"username", "password"})
    public void testLogin(String username, String password) {
        loginPro.login(username, password);
        driver.sleep(5000);
        if (homePagePro.AssertLogin(proUtil.getPro("yq"))) {
            System.out.println("登陆成功" + username);
            //确定登录成功后,写入我们当前用户的Cookie
            handleCookie.writeCookie();
        }
    }


    @AfterClass
    public void afterClass() {
        driver.getDriver().close();
    }

}
