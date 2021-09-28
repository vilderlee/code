package com.vilderlee.reflect;

import com.vilderlee.annotation.TestHolder;

import java.lang.reflect.Method;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/10      Create this file
 * </pre>
 */
public class ReflectTest {

    public static void main(String[] args) throws Exception {

        TestHolder testHolder = new TestHolder();
        Class c = testHolder.getClass();
        Method method = c.getMethod("setString", String.class);
        method.invoke(null,"hello world!");
        Method method1 = c.getMethod("test", null);
        method1.invoke(testHolder);
    }
}
