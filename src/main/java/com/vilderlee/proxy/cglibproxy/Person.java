package com.vilderlee.proxy.cglibproxy;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/18      Create this file
 * </pre>
 */
public class Person {

    public final void eat(String something) {
        System.out.println("我吃" + something);
    }


    public final void sayHello() {
        System.out.println("hello world!");
    }
}
