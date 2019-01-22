package com.vilderlee.proxy.cglibproxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/21      Create this file
 * </pre>
 */
public class ProxyFactory {
    public static Object getInstance(Class clz) throws Throwable {

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"C:\\Users\\dell\\Desktop");
        //这里叫做代理对象增强器
        Enhancer enhancer = new Enhancer();
        //设置要代理的类
        enhancer.setSuperclass(clz);
        //设置回调方法，其实就是代理类方法
        enhancer.setCallback(new MethodInvocationHander());
        //创建代理对象并返回
        return enhancer.create();
    }
}
