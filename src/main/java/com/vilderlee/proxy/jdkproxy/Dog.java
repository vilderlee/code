package com.vilderlee.proxy.jdkproxy;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/18      Create this file
 * </pre>
 */
public class Dog implements Eat {

    @Override
    public final void eat(String something) {
        System.out.println("我吃" + something);
    }
}
