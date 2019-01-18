package com.study.spring;

import org.springframework.beans.factory.InitializingBean;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/18      Create this file
 * </pre>
 */
public class Test implements InitializingBean {

    @Override public void afterPropertiesSet() throws Exception {
        System.out.println("我的天呢");
    }

    public void print() {
        System.out.println("我在打印");
    }
}
