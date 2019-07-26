package com.study.spring.aop.utils;


import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 功能描述: 这是一个前置增强
 *
 * @package com.study.spring.aop.utils
 * @auther vilderlee
 * @date 2019-01-23 23:17
 */
public class MyAdvice implements MethodBeforeAdvice {


    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("我是人，我在洗手");
    }
}
