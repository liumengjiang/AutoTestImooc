package com.lj.nice.page;

import com.lj.nice.base.DriverBase;
import com.lj.nice.util.GetByLocator;
import org.openqa.selenium.WebElement;

public class SureOrderPage extends BasePage{
    public SureOrderPage(DriverBase driverBase) {
        super(driverBase);
        // TODO Auto-generated constructor stub
    }
    /**
     * 获取提交订单按钮
     *
     * */
    public WebElement getSureOrderButton() {
        return element(GetByLocator.getLocator("sureOrder"));
    }

}
