package com.vilderlee.quartz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/29      Create this file
 * </pre>
 */
public final class Environment {

    public static ApplicationContext context = new ClassPathXmlApplicationContext();


    public static void init(){
        context = new ClassPathXmlApplicationContext("spring2.xml");
        ((ClassPathXmlApplicationContext) context).start();
    }
}
