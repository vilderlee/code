package com.vilderlee.thread;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/9/5      Create this file
 * </pre>
 */
public class Test {

    private final Lock lock = new ReentrantLock();

    public int f(int i) {
        try {
            lock.lock();
            if (i > 100) {
                System.out.println("12312");
                return 0;
            } else {
                return f(i++);
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(()-> {
            System.out.println(LocalTime.now());
        },0L,1L, TimeUnit.SECONDS);
    }
}
