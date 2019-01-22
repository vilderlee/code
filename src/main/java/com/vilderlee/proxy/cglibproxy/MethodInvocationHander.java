package com.vilderlee.proxy.cglibproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/21      Create this file
 * </pre>
 */
public class MethodInvocationHander implements MethodInterceptor {

    /**
     * 对象方法执行的地方
     *
     * @param proxyObject   生成的代理对象
     * @param method    调用的实际方法
     * @param objects   调用的实际方法的参数
     * @param methodProxy   代理方法
     * @return
     * @throws Throwable
     */
    @Override public Object intercept(Object proxyObject, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("方法拦截前");

        //通过代理对象方法调用需要调用的方法 注意这里是invokeSuper 不是invoke
        Object returnObject = methodProxy.invokeSuper(proxyObject, objects);

        System.out.println("方法拦截后");


        return returnObject;



    }
}
