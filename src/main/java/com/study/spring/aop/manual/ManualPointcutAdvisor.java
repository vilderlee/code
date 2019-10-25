package com.study.spring.aop.manual;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;

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
public class ManualPointcutAdvisor implements PointcutAdvisor {

    private Pointcut pointcut;

    private Advice advice;

    public ManualPointcutAdvisor(Pointcut pointcut, Advice advice) {
        this.pointcut = pointcut;
        this.advice = advice;
    }

    @Override public Pointcut getPointcut() {
        return pointcut;
    }

    @Override public Advice getAdvice() {
        return advice;
    }

    @Override public boolean isPerInstance() {
        return false;
    }
}
