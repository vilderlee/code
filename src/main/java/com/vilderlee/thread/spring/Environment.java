package com.vilderlee.thread.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/5/7      Create this file
 * </pre>
 */
public class Environment {


   public static  ApplicationContext context;

    public static void init(){
         context = new AnnotationConfigApplicationContext(SpringConfig.class);
    }


}
