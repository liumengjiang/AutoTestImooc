package com.lj.nice.handle;

import com.lj.nice.base.DriverBase;
import com.lj.nice.page.CoursePage;
import org.openqa.selenium.WebElement;

public class CoursePageHandle {
    private DriverBase driver;
    private CoursePage coursePage;
    public CoursePageHandle(DriverBase driver) {
        // TODO Auto-generated constructor stub
        this.driver=driver;
        coursePage=new CoursePage(driver);
    }
    /**
     * 点击立即购买按钮
     *
     * */
    public void clickBuyNow() {
        coursePage.click(coursePage.getPurchaseNowElement());
    }
    /**
     * 点击添加购物车按钮
     *
     * */
    public void clickAddCart() {
        coursePage.click(coursePage.getAddCartElement());
    }
    /**
     *
     * 点击右上角购物车
     * */
    public void clickShopCart() {
        coursePage.click(coursePage.getShopCartElement());
    }

    /**
     *
     * 获取购物车数量
     * */
    public String getShopCartNum() {
        WebElement element=coursePage.getShopCartNumElement();
        return coursePage.getText(element);
    }
    /**
     * 获取课程名称
     *
     * */
    public String getCourseName() {
        return coursePage.getText(coursePage.getCourseNameElement());
    }
    /**
     *
     * 点击已经购买弹窗的确定按钮
     * */
    public void clickReadBuy() {
        coursePage.click(coursePage.getReadyBuy());
    }

    /**
     * 去结算
     * */
    public void clickGoPay(){
        coursePage.click(coursePage.getGoPayElement());
    }

}


