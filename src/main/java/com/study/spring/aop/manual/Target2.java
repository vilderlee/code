package com.study.spring.aop.manual;

import org.springframework.stereotype.Component;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/8/29      Create this file
 * </pre>
 */
@Component public class Target2 {

    public void test() {
        System.out.println("test is processing");
    }

    public void test2() {
        System.out.println("test2 is processing");
    }

    public void test3(String arg) {
        System.out.println("test3 is processing, arg:" + arg);
    }
}
