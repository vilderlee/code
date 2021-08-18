package com.vilderlee.thread.activeobject;

import org.omg.PortableServer.Servant;

import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;

/**
 * Proxy
 *
 * @ClassName Proxy
 * @Description
 * @Author VilderLee
 * @Date 2021/8/10 7:57 下午
 */

public class ProxyM {

    public static <T> T newInstance(Class<T> interfaces, ExecutorService scheduler, Servant servant) {
        CustomInvocationHandler handler = new CustomInvocationHandler(servant, scheduler);
        T proxyInstance = (T) Proxy.newProxyInstance(interfaces.getClassLoader(), new Class[]{interfaces}, handler);
        return proxyInstance;
    }
}
