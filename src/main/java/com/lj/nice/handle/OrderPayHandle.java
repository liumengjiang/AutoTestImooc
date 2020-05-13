package com.lj.nice.handle;

import com.lj.nice.base.DriverBase;
import com.lj.nice.page.OrderPayPage;

public class OrderPayHandle {
    public DriverBase driverBase;
    public OrderPayPage orderPayPage;
    public OrderPayHandle(DriverBase driverBase) {
        this.driverBase=driverBase;
        orderPayPage=new OrderPayPage(driverBase);
    }

    /**
     * 获取订单文字
     *
     * */
    public String getOrderName() {
        return orderPayPage.getText(orderPayPage.getOrderNumElement());
    }
    /**
     * 获取课程名称
     *
     * */
    public String getOrderCourseName() {
        return orderPayPage.getText(orderPayPage.getOrderCoureNameElement());
    }
    /**
     * 点击支付宝支付
     *
     * */
    public void clickAliPay() {
        orderPayPage.click(orderPayPage.getAliPayElement());
    }

    /**
     * 点击立即支付
     *
     * */
    public void clickPayElement() {
        orderPayPage.click(orderPayPage.getOrderPayElement());
    }

}
