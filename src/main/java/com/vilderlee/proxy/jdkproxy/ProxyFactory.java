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

        /**
         *
         *  ClassLoader loader, 被代理类的加载器
         *  Class<?>[] interfaces,  被代理类的所有接口
         *  InvocationHandler h 调用的处理器
         *
         *  return 代理对象
         */
        Object object = Proxy.newProxyInstance(clz.getClassLoader(), clz.getInterfaces(), new Invocation(clz.newInstance()));
        return object;
    }
}
