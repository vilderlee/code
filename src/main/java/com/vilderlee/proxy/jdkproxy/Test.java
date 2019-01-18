package com.vilderlee.proxy.jdkproxy;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/18      Create this file
 * </pre>
 */
public class Test {

    public static void main(String[] args) {
        try {
            Eat eat = (Eat) ProxyFactory.getInstance(Person.class);
            eat.eat("肉");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
