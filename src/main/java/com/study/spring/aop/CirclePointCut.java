package com.study.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/8/20      Create this file
 * </pre>
 */
@Aspect
@Component
public class CirclePointCut {

    @Pointcut("execution(* com.study.spring.aop.CircleServiceImpl.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void before(){
        System.out.println("Before------------------");
    }
}
