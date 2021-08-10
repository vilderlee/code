package com.study.spring.condition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Conditional;

/**
 * Main
 *
 * @ClassName Main
 * @Description
 * @Author VilderLee
 * @Date 2021/2/2 4:25 下午
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    }
}
