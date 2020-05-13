package com.lj.nice.business;

import com.lj.nice.base.DriverBase;
import com.lj.nice.handle.CoursePageHandle;

import java.util.List;



public class CoursePagePro {
    public DriverBase driver;
    public CoursePageHandle coursePageHandle;
    public CoursePagePro(DriverBase driver) {
        this.driver=driver;
        coursePageHandle=new CoursePageHandle(driver);
    }

    /**
     *
     * 添加购物车
     * */
    public void addCart() {
        int beforeNum;
        String afterCourseNum;
        int afterNum;
        //在没点击加入购物车按钮前,先获得购物车商品的数量
        String courseNum=coursePageHandle.getShopCartNum();
        try {
            beforeNum=Integer.valueOf(courseNum);
            System.out.println(beforeNum);
        }catch(Exception e){
            beforeNum=0;
        }
        //点击加入购物车
        coursePageHandle.clickAddCart();
        try {
            //转接模态框
            driver.switchToMode();
            //点击“立即购买”按钮
            coursePageHandle.clickBuyNow();
        } catch (Exception e) {
            // TODO: handle exception
        }

        // 得到购物车商品的数量
        afterCourseNum = coursePageHandle.getShopCartNum();
        try {
            afterNum=Integer.valueOf(afterCourseNum);
            System.out.println(afterNum);
        } catch (Exception e) {
            afterNum=beforeNum;
        }
        driver.sleep(2000);
        if(afterNum==beforeNum+1) {
            System.out.println("添加购物车成功!");
            //点击右上角的购物车按钮
            coursePageHandle.clickShopCart();
            driver.sleep(2000);
            //点击去结算按钮
            coursePageHandle.clickGoPay();
        }else if(afterNum>0) {
            //点击右上角的购物车按钮
            coursePageHandle.clickShopCart();
            driver.sleep(2000);
            //点击去结算按钮
            coursePageHandle.clickGoPay();
        }else {
            //点击右上角的购物车按钮
            coursePageHandle.clickShopCart();
            driver.sleep(5000);
            List<String> list=driver.getWindowsHandles();
            driver.switchWindows(list.get(1));
            System.out.println(driver.getTitle());
            coursePageHandle.clickGoPay();
        }
    }

    /**
     * 点击立即购买按钮
     *
     * */
    public void buyNow() {
        coursePageHandle.clickBuyNow();
    }

}
