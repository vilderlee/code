package com.vilderlee.spi;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/10      Create this file
 * </pre>
 */
public class SayByChinese implements Say{
    @Override public void sayHello() {
        System.out.println("你好！");
    }
}
