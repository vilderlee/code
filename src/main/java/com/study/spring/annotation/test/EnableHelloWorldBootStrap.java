package com.study.spring.annotation.test;

import com.study.spring.annotation.EnableHelloWorld;
import com.study.spring.annotation.test.select.Server;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/6/17      Create this file
 * </pre>
 */
@EnableHelloWorld(proxy = Server.Type.TCP)
@Configuration public class EnableHelloWorldBootStrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                EnableHelloWorldBootStrap.class);
        Server server = context.getBean(Server.class);
        server.start();
        context.close();
    }
}
