package com.lj.nice.util;

import com.lj.nice.base.DriverBase;
import java.util.Set;

import org.openqa.selenium.Cookie;

public class HandleCookie {
    public DriverBase driverBase;
    //要读取cookie.properties配置文件,所以需要Proutil工具类
    public ProUtil proUtil;
    public HandleCookie(DriverBase driverBase) {
        this.driverBase=driverBase;
        proUtil=new ProUtil("cookie.properties");
    }

    /**
     * 设置cookie方法
     *
     * */
    public void setCookie() {
        String value=proUtil.getPro("apsid");
        /**
         * 五个参数的
         * 第一个参数:cookie的名称，任意取
         * 第二个参数:cookie的值
         * 第三个参数:path:域名地址-代表我们只要是我们所测网站的域名，都表示有效
         * 第四个代表全部路径下
         * 第五个参数:日期
         * */
        Cookie cookie=new Cookie("apsid", value, "imooc.com", "/",null);
        //把当前的cookie成功添加到Set<Cookie>集合中,在DriverBase类中封装了setCookie方法
        driverBase.setCookie(cookie);
    }
    /**
     * 获取cookie方法
     * 原理:
     *
     * */
    public void writeCookie() {
        Set<Cookie> cookies=driverBase.getCookie();
        for(Cookie cookie:cookies) {
            if(cookie.getName().equals("apsid")) {
                proUtil.writePro(cookie.getName(),cookie.getValue());
            }
        }
    }

}
