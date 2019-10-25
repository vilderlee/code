package com.study.spring.aop.manual;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/8/29      Create this file
 * </pre>
 */
public class ManualAopMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AopCofiguration.class);

        Target bean = context.getBean(Target.class);
        Target2 bean2 = context.getBean(Target2.class);
//        bean.test();
//        bean.test2();
        bean.test3("Hello World!");
        bean2.test3("Hello World!22222222222");
    }
}
