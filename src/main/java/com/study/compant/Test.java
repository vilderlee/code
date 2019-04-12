package com.study.compant;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/4/12      Create this file
 * </pre>
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        Map map = context.getBeansWithAnnotation(DespositMode.class);

        Object o = map.values();

    }
}
