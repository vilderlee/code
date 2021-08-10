package com.vilderlee.proxy.javaagent;

import java.lang.management.ManagementFactory;

/**
 * Base
 *
 * @ClassName Base
 * @Description
 * @Author VilderLee
 * @Date 2021/7/31 5:47 下午
 */

public class Base {
    public static void main(String[] args) {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
        while (true) {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            process();
        }
    }

    public static void process() {
        System.out.println("process");
    }
}
