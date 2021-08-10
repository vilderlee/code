package com.study.spring.cycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/15      Create this file
 * </pre>
 */
@ComponentScan("com.study.spring.cycle")
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        TestA testA = (TestA) context.getBean("testA");
//        testA.test();

        System.out.println(context.containsLocalBean("vilder"));
        System.out.println(context.containsLocalBean("testA"));

    }
}
