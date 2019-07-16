package com.study.spring.annotation.test.select;

import org.springframework.stereotype.Component;

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
@Component("tcpServer")
public class TcpServer implements Server {

    @Override public void start() {
        System.out.println("TCP Server is starting !");
    }

    @Override public void stop() {
        System.out.println("TCP Server is stop !");
    }
}
