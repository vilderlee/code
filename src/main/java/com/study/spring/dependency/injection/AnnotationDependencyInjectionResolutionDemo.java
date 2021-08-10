package com.study.spring.dependency.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName AnnotationDependencyinjectionResolutionDemo
 * @Description
 * @Author VilderLee
 * @Date 2020/12/2 5:11 下午
 */
@Configuration
public class AnnotationDependencyInjectionResolutionDemo {

    @Autowired
    private User user;


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.study.spring.dependency.injection");
//        context.register(AnnotationConfigApplicationContext.class);
//        context.refresh();
        User bean = context.getBean(User.class);
        System.out.println();
    }
}
