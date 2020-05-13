package com.lj.nice.testcase;

import com.lj.nice.base.DriverBase;

public class CaseBase {

    public DriverBase InitDriverBase(String browser) {

        return new DriverBase(browser);
    }
}
