package com.vilderlee.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/18      Create this file
 * </pre>
 */
public class Invocation implements InvocationHandler {

    public Invocation(Object object) {
        this.object = object;
    }

    /**
     * 实际对象
     */
    private Object object;

    /***
     *  这个方法就是要告诉代理对象要处理的方法
     *
     * @param proxy 代理对象
     * @param method    实例对象要调用的方法
     * @param args  实例对象要调用的方法的参数
     * @return  Object
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (object instanceof Person){
            wash();
        }else if(object instanceof Dog){
            sound();
        }

        return method.invoke(object, args);
    }

    private void wash(){
        System.out.println("我是人，我要洗手");
    }

    private void sound(){
        System.out.println("我是狗，汪汪汪");
    }
}
