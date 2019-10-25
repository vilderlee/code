package com.study.spring.aop.manual;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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
@Configuration
@ComponentScan
public class AopCofiguration {

    @Bean public Pointcut pointCut() {
        return new ManualPointCut();
    }

    @Bean public Advice advice() {
        return new ManualAdvice();
    }
    @Bean public PointcutAdvisor pointcutAdvisor() {
        return new ManualPointcutAdvisor(pointCut(), advice());
    }

    @Bean public AbstractAdvisorAutoProxyCreator autoProxyCreator(){
        DefaultAdvisorAutoProxyCreator autoProxyCreator = new DefaultAdvisorAutoProxyCreator();

        return autoProxyCreator;
    }


//    @Bean public AbstractAutoProxyCreator autoProxyCreator2(){
//        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
//        beanNameAutoProxyCreator.setInterceptorNames("pointcutAdvisor");
////        beanNameAutoProxyCreator.setBeanNames("target*");
//        return beanNameAutoProxyCreator;
//    }
}
