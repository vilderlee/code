package com.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/16      Create this file
 * </pre>
 */
public class SpringTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Test3 test = (Test3) context.getBean("test3");
        test.test3();

        ((ClassPathXmlApplicationContext) context).start();
        ((ClassPathXmlApplicationContext) context).close();
    }
}
