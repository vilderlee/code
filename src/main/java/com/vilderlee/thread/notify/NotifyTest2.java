package com.vilderlee.thread.notify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/16      Create this file
 * </pre>
 */
public class NotifyTest2 {

    public static void main(String[] args) {
        Resource a = new Resource();

        new Thread(() -> {
            a.testA();
        }, "A").start();
        new Thread(() -> {
            a.testB();
        }, "B").start();

    }

    static class Resource {

        private Lock lock = new ReentrantLock();
        private Condition a = lock.newCondition();
        private Condition b = lock.newCondition();
        private volatile int num = 1;

        public void testA() {
            for (int i = 1; i < 54; i++) {
                lock.lock();
                try {
                    while (num != 1) {
                        a.await();
                    }
                    System.out.print(i + "" +  ++i);
                    num = 2;
                    b.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }

        public void testB() {

            for (char i = 'A'; i <= 'Z'; i++) {
                lock.lock();
                try {
                    while (num != 2) {
                        b.await();
                    }
                    System.out.print(i);
                    num = 1;
                    a.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }

    }
}