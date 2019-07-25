package com.vilderlee.thread.notify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类说明:
 * <p>
 * 分析： 这道题的解法 如何唤醒另一个线程，一个线程阻塞，另一个线程去唤醒。
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/16      Create this file
 * </pre>
 */
public class NotifyTest {

    public static void main(String[] args) {
        Resource a = new Resource();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                a.testA();
            }, "A").start();
            new Thread(() -> {
                a.testB();
            }, "B").start();
            new Thread(() -> {
                a.testC();
            }, "C").start();
        }

    }

    static class Resource {

        private Lock lock = new ReentrantLock();
        private Condition a = lock.newCondition();
        private Condition b = lock.newCondition();
        private Condition c = lock.newCondition();
        private volatile int num = 1;

        public void testA() {
            lock.lock();
            try {
                while (num != 1) {
                    a.await();
                }

                System.out.println("A");
                num = 2;
                b.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void testB() {
            lock.lock();
            try {
                while (num != 2) {
                    b.await();
                }
                System.out.println("B");
                num = 3;
                c.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void testC() {
            lock.lock();
            try {
                while (num != 3) {
                    c.await();
                }
                System.out.println("C");
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

