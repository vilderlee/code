package com.vilderlee.proxy.jdkproxy;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/18      Create this file
 * </pre>
 */
    public class Person implements Eat {

        @Override
        public void eat(String something) {
            System.out.println("我吃" + something);
        }
    }
