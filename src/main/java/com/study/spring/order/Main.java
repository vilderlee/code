package com.study.spring.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 类说明: 证明Order值越大优先级越低
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/10/23      Create this file
 * </pre>
 */

@Component
public class Main {

    @Autowired
    private List<Test> list;

    public void testCall(){
        list.forEach(Test::test);
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.study.spring.order");
        Main bean = context.getBean(Main.class);
        bean.testCall();
    }
}
