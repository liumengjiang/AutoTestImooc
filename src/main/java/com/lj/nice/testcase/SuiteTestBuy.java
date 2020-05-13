package com.lj.nice.testcase;

import com.lj.nice.base.DriverBase;
import com.lj.nice.business.CoursePagePro;
import com.lj.nice.util.HandleCookie;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SuiteTestBuy extends CaseBase{
    public DriverBase driverBase;
    public CoursePagePro coursePagePro;
    public HandleCookie handleCookie;

    @BeforeClass
    public void beforeClass() {
        this.driverBase=InitDriverBase("chrome");
        coursePagePro=new CoursePagePro(driverBase);
        //为了得到我们添加到Set集合中的cookie，所以我们需要得到handlecookie对象
        handleCookie=new HandleCookie(driverBase);

        /**
         *
         *易错点:先执行handleCookie.setCookie();
         *再进入网页driverBase.get("http://coding.imooc.com/class/149.html");
         * 错误原因:典型的执果索因,如果我们提前设置cookie，猛一看上去没毛病,
         * 但仔细一想,你都不知道进哪个网页,你把cookie设置给谁呢?我们的大前提弄错了
         *
         * driverBase.get("http://coding.imooc.com/class/149.html");
         * handleCookie.setCookie();
         * 进入页面后紧接着设置完cookie后,网页不会自动刷新,所以我们要自己重新加载一下网页
         *
         * */
        //直接进入到课程页面
        driverBase.get("http://coding.imooc.com/class/149.html");
        //指定用户的cookie，相当于指定了谁登陆
        handleCookie.setCookie();
        //设定完Cookie后,必须重新加载一下页面,否则会失败
        driverBase.get("http://coding.imooc.com/class/149.html");


    }
    @Test
    public void testBuy() {
        //执行立即购买
        coursePagePro.buyNow();
        //driverBase.sleep(2000);
    }
    @AfterClass
    public void afterClass() {
        //driverBase.getDriver().close();
    }
}

