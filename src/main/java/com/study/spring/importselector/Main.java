package com.study.spring.importselector;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * 功能描述:
 *
 * @package com.study.spring.importselector
 * @auther vilderlee
 * @date 2019-06-29 22:36
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        String[] beanNames = context.getBeanDefinitionNames();
        for (int i = 0; i < beanNames.length; i++) {
            System.out.println(beanNames[i]);
        }

        TimeUnit.SECONDS.sleep(10000);
    }
}
