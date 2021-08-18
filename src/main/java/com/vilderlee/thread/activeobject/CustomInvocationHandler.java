package com.vilderlee.thread.activeobject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Proxy
 *
 * @ClassName Proxy
 * @Description
 * @Author VilderLee
 * @Date 2021/8/9 8:38 下午
 */

public class CustomInvocationHandler implements InvocationHandler {

    private final Object target;
    private final ExecutorService scheduler;

    public CustomInvocationHandler(Object target, ExecutorService scheduler) {
        this.target = target;
        this.scheduler = scheduler;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Callable<Object> methodRequest = () -> {

            return null;
        };

        Future<Object> future = scheduler.submit(methodRequest);

        return future;
    }
}
