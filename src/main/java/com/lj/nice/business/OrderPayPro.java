package com.lj.nice.business;

import com.lj.nice.base.DriverBase;
import com.lj.nice.handle.OrderPayHandle;
import org.openqa.selenium.JavascriptExecutor;

public class OrderPayPro {
    public DriverBase driverBase;
    public OrderPayHandle orderPayHandle;

    public OrderPayPro(DriverBase driverBase) {
        this.driverBase = driverBase;
        orderPayHandle = new OrderPayHandle(driverBase);
    }

    /**
     * 根据课程信息与订单是否正确判断是否跳转到支付页面
     */
    public void orderPayPro() {
        String orderName = orderPayHandle.getOrderName();
        String orderCourseName = orderPayHandle.getOrderCourseName();
        if (orderName != null && orderCourseName != null) {
            //选中支付宝支付
            orderPayHandle.clickAliPay();
            //点击立即支付
            JavascriptExecutor js = (JavascriptExecutor) driverBase.getDriver();
            js.executeScript("arguments[0].click();", orderPayHandle.orderPayPage.getOrderPayElement());
            //orderPayHandle.clickPayElement();
        }
    }
}