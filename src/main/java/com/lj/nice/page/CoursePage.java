package com.lj.nice.page;

import com.lj.nice.base.DriverBase;
import com.lj.nice.util.GetByLocator;
import org.openqa.selenium.WebElement;

public class CoursePage extends BasePage{
    public CoursePage(DriverBase driverBase) {
        super(driverBase);
        // TODO Auto-generated constructor stub
    }
    /*
     * 获取"立即购买"按钮element
     *
     * */
    public WebElement getPurchaseNowElement() {
        return element(GetByLocator.getLocator("purchaseNow"));
    }
    /**
     * 获取添加购物车element
     *
     * */
    public WebElement getAddCartElement() {
        return element(GetByLocator.getLocator("addCart"));
    }
    /**
     * 获取右上角购物车element
     *
     * */
    public WebElement getShopCartElement() {
        return element(GetByLocator.getLocator("shopCart"));
    }
    /**
     * 获取购物车数量element
     *
     * */
    public WebElement getShopCartNumElement() {
        return element(GetByLocator.getLocator("cartNum"));
    }
    /**
     * 获取课程详情页面左上角课程名element
     *
     * */
    public WebElement getCourseNameElement() {
        return getChildrenElement(GetByLocator.getLocator("courseInfo"), GetByLocator.getLocator("courseInfoText"));
    }
    /**
     * 通过字符节点定位已经购买弹窗确定按钮
     *
     * */
    public WebElement getReadyBuy() {
        return getChildrenElement(GetByLocator.getLocator("readBuySure"), GetByLocator.getLocator("readBuySureNode"));
    }

    /**
     * 购物车页面去结算
     * */
    public WebElement getGoPayElement(){
        return getChildrenElement(GetByLocator.getLocator("shopgopay"),GetByLocator.getLocator("shopgopayNode"));
    }



}
