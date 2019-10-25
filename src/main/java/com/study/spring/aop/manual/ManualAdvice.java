package com.study.spring.aop.manual;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/8/29      Create this file
 * </pre>
 */
public class ManualAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(this.getClass().getSimpleName() + "is starting");
        System.out.println("method:" + method.getName());
        System.out.println("    ");
        System.out.println("args:****");
        Stream.of(args).forEach(System.out::println);
        System.out.println("args:****");
        System.out.println("    ");
        System.out.println("target:" + target.getClass().getSimpleName());
    }
}
