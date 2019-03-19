package com.vilderlee.thread;

import java.util.concurrent.TimeUnit;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/4      Create this file
 * </pre>
 */
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "正在执行");
        }, "thread1");

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "正在执行");
        }, "thread2");

        Thread thread3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "正在执行");
        }, "thread3");

        thread1.start();
        thread1.join();

        thread2.start();
        thread2.join();

        thread3.start();
        thread3.join();
    }
}
