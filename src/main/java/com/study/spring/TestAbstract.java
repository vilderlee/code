package com.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/26      Create this file
 * </pre>
 */
public class TestAbstract {

    public static void main(String[] args) throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        AbstractTemplate test = (AbstractTemplate) context.getBean("doService");

        test.doBusiness(2,"hello");

    }
}
