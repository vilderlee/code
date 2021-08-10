package com.vilderlee.netty.tomcat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * Tomcat
 *
 * @ClassName Tomcat
 * @Description
 * @Author VilderLee
 * @Date 2021/4/27 11:14 下午
 */

public class Tomcat {

    public Tomcat(int port) {
        this.port = port;
    }

    private int port;

    public void start() throws Exception {
        EventLoopGroup boos = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();

//        Bootstrap
    }

}
