package com.study.spring.demo;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/27      Create this file
 * </pre>
 */
public class ThirdService extends AbstractTemplate {

    @Override
    protected void doIt(String message) {
        System.out.println("ThirdService:" + message);
    }

}
