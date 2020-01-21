package com.study.dispatcher;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/12/16      Create this file
 * </pre>
 */
@Configuration
@ComponentScan("com.study.dispatcher")
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        Dispatcher dispatcher = context.getBean(Dispatcher.class);
        dispatcher.dispatcher(20,"1141");
    }
}
