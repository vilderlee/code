package com.study.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/16      Create this file
 * </pre>
 */
public class SpringTest {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Test3 t = (Test3) context.getBean("test3");
        t.test();
//        ((ClassPathXmlApplicationContext) context).start();
        System.in.read();
    }
}
