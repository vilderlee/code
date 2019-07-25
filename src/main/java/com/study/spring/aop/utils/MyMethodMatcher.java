package com.study.spring.aop.utils;

import org.springframework.aop.MethodMatcher;

import java.lang.reflect.Method;

/**
 * 功能描述:
 *
 * @package com.study.spring.aop.utils
 * @auther vilderlee
 * @date 2019-01-23 23:24
 */
public class MyMethodMatcher implements MethodMatcher {

    /**
     * 静态拦截 默认方法没有重载
     *
     * @param method
     * @param targetClass
     * @return
     */
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        if (method.getName().equals("eat") ) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isRuntime() {
        return false;
    }


    /**
     * 动态拦截 方法可能是多个
     *
     * @param method
     * @param targetClass
     * @param args
     * @return
     */
    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        System.out.println(method.getName().equals("eat") );
        System.out.println("args" + args);
        if (method.getName().equals("eat") && args == null) {
            return true;
        }

        return false;
    }
}
