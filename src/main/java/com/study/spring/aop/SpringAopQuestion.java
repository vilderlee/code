package com.study.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/24      Create this file
 * </pre>
 */
public class SpringAopQuestion {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");

        CircleServiceImpl circleServiceImpl = (CircleServiceImpl) context.getBean("circleServiceImpl");

        circleServiceImpl.draw();

    }
}
