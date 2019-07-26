package com.study.spring.aop.utils;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

/**
 * 功能描述: 确认我要拦截哪个类 哪个方法
 *
 * @package com.study.spring.aop.utils
 * @auther vilderlee
 * @date 2019-01-23 23:21
 */
public class MyPointCut implements Pointcut {
    private ClassFilter classFilter;
    private MethodMatcher methodMatcher;

    @Override
    public ClassFilter getClassFilter() {
        return classFilter;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setClassFilter(ClassFilter classFilter) {
        this.classFilter = classFilter;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }
}
