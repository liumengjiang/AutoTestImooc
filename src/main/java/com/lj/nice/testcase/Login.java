package com.lj.nice.testcase;

import com.lj.nice.base.DriverBase;
import com.lj.nice.business.CoursePagePro;
import com.lj.nice.business.LoginPro;
import com.lj.nice.business.OrderPayPro;
import com.lj.nice.business.SureOrderPro;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class Login extends CaseBase{
    public DriverBase driverBase;
    public LoginPro loginPro;
    public CoursePagePro coursePagePro;
   public SureOrderPro sureOrderPro;
    public OrderPayPro orderPayPro;
    //使用静态声明主要是为了在第一次进来的时候就调用生成，并且有且仅有一次
    static Logger logger=Logger.getLogger(Login.class);
    //@BeforeClass代表在运行第一个@Test之前执行这个方法
    public void loginTest() {
        //确定运行脚本的为chrome浏览器，并且赋值给当前类的DriverBase
        this.driverBase=InitDriverBase("chrome");
        loginPro=new LoginPro(driverBase);
        coursePagePro=new CoursePagePro(driverBase);
        //sureOrderPro=new SureOrderPro(driverBase);
        //orderPayPro=new OrderPayPro(driverBase);
    }
    public void getLoginHome() {
        //driverBase
        driverBase.get("http://www.imooc.com");
        driverBase.getWindowMax();
        driverBase.findElement(By.id("js-signin-btn")).click();
        //driverBase.findElement(GetByLocator.getLocator("loginButton")).click();
        driverBase.sleep(2000);
    }
    //@Test(dependsOnMethods={"getLoginHome"})
    //@Parameters({"username","password"})
    public void testLogin(String username,String password) {
        //logger.debug("的空间里的封建时代放疗科大夫——————————————————————————————————————————————————————");
        loginPro.login(username,password);
    }

    /**
     * 添加购物车
     *
     * */
    @Test(dependsOnMethods={"testLogin"})
    public void addCart() {
        driverBase.sleep(2000);
        driverBase.get("http://coding.imooc.com/class/147.html");
        coursePagePro.addCart();
    }

    /**
     * 提交订单
     *
     * */
    @Test(dependsOnMethods={"addCart"})
    public void TestSureOrder() {
        sureOrderPro.sureOrder();
    }

    /**
     * 跳转支付页面进行支付
     *
     * */
    @Test(dependsOnMethods={"TestSureOrder"})
    public void testGoBuy() {
        driverBase.sleep(2000);
        orderPayPro.orderPayPro();
    }
    @AfterClass
    public void closeDriver() {
        driverBase.getDriver().close();
    }

    public static void main(String[] args) {
        Login login = new Login();
        login.loginTest();
        login.getLoginHome();
    }
}
