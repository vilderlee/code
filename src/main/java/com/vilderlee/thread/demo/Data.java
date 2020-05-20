package com.vilderlee.thread.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述:
 *
 * @package com.vilderlee.thread.demo
 * @auther vilderlee
 * @date 2019/12/14 11:02 下午
 */
public class Data {
    private volatile int i = 0;
    private final Object object = new Object();

    public synchronized void set() throws InterruptedException {
        System.out.println(LocalDateTime.now());
        TimeUnit.SECONDS.sleep(10);
        i++;
    }

    public int get() throws InterruptedException {
        System.out.println(LocalDateTime.now());
        TimeUnit.SECONDS.sleep(3);
        return i;
    }


    public static void main(String[] args) {
        Data data = new Data();


        new Thread(() -> {
            try {
                data.set();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
        new Thread(() -> {
            try {
                System.out.println(data.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();

    }
}
