package com.study.spring.annotation.test.select;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/12      Create this file
 * </pre>
 */
public class HttpServer implements Server {

    @Override public void start() {
        System.out.println("HttpServer is starting !");
    }

    @Override public void stop() {
        System.out.println("HttpServer is stop !");
    }
}
