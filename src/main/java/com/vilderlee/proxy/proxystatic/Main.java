package com.vilderlee.proxy.proxystatic;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/15      Create this file
 * </pre>
 */
public class Main {
    public static void main(String[] args) {
        Eat eat = new StaticProxy("wangwang");
        eat.eat();
    }
}
