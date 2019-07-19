package com.study.spring.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/18      Create this file
 * </pre>
 */
public class Main {

    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(TransactionConfig.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-transaction.xml");
        UserDao userDao = context.getBean(UserDao.class);
        userDao.insert();
    }
}
