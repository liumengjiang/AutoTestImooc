package com.lj.nice.handle;

import com.lj.nice.base.DriverBase;
import com.lj.nice.page.SureOrderPage;

public class SureOrderPageHandle {
    public DriverBase driverBase;
    public SureOrderPage sureOrderPage;
    public SureOrderPageHandle(DriverBase driverBase) {
        this.driverBase=driverBase;
        sureOrderPage=new SureOrderPage(driverBase);
    }
    /**
     * 点击"提交订单按钮"
     *
     * */
    public void clickSureOrderButton() {
        driverBase.click(sureOrderPage.getSureOrderButton());
    }

}
