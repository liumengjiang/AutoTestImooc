package com.lj.nice.page;

import com.lj.nice.base.DriverBase;
import com.lj.nice.util.GetByLocator;
import org.openqa.selenium.WebElement;

public class OrderPayPage extends BasePage{
    public OrderPayPage(DriverBase driverBase) {
        super(driverBase);
        // TODO Auto-generated constructor stub
    }

    /**
     *
     * 获取订单号element
     * */
    public WebElement getOrderNumElement() {
        return element(GetByLocator.getLocator("orderNum"));
    }
    /**
     * 返回课程名称element
     *
     * */
    public WebElement getOrderCoureNameElement() {
        return element(GetByLocator.getLocator("orderCourseNode"));
    }
    /**
     * 返回支付宝element
     *
     * */
    public WebElement getAliPayElement() {
        return element(GetByLocator.getLocator("alipay"));
    }

    /**
     * 获取"立即支付"element
     *
     * */
    public WebElement getOrderPayElement() {
        return element(GetByLocator.getLocator("orderPay"));
    }

}
