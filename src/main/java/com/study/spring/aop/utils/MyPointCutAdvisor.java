package com.study.spring.aop.utils;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;

/**
 * 功能描述:
 *
 * @package com.study.spring.aop.utils
 * @auther vilderlee
 * @date 2019-01-23 23:21
 */
public class MyPointCutAdvisor implements PointcutAdvisor {

    private Pointcut pointcut;
    private Advice advice;

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }

    public void setPointcut(Pointcut pointcut) {
        this.pointcut = pointcut;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
