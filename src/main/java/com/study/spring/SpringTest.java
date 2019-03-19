package com.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Constructor;

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
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//
//        Test test = (Test) context.getBean("factoryBeanTest");
//
//        System.out.println(test.test());

        try {
            Constructor[] constructors = Test2.class.getDeclaredConstructors();
            constructors[0].setAccessible(true);

            Test2 test2s = (Test2) constructors[0].newInstance();
            test2s.test2();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
