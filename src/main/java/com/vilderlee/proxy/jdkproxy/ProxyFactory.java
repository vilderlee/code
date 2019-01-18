package com.vilderlee.proxy.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/18      Create this file
 * </pre>
 */
public class ProxyFactory {

    public static Object getInstance(Class clz) throws IllegalAccessException, InstantiationException {
        return Proxy.newProxyInstance(clz.getClassLoader(), clz.getInterfaces(), new Invocation(clz.newInstance()));
    }
}
