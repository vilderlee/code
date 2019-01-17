package com.vilderlee.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/17      Create this file
 * </pre>
 */
public class ReentrantLockTest implements Runnable {

    ReentrantLock lock = new ReentrantLock();
    private int string = 0;

    public ReentrantLock getLock() {
        return lock;
    }

    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(10);
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        for (int i = 0; i < 10; i++) {
            executor.execute(reentrantLockTest);
        }

        ((ExecutorService) executor).shutdown();
    }

    @Override public void run() {
        System.out.println(Thread.currentThread().getName() + "获得锁" );
        lock.lock();
        string++;
        System.out.println(string + ":" + Thread.currentThread().getName());
        lock.unlock();
    }
}
