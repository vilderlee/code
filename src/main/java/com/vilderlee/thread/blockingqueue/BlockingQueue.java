package com.vilderlee.thread.blockingqueue;

import java.util.concurrent.TimeUnit;
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
public class BlockingQueue<T> {

    private volatile int size = 0;
    private final int initSize;
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    private Object[] items;

    public BlockingQueue(int initSize) {
        this.initSize = initSize;
        items = new Object[initSize];
    }

    public void put(Object object) {

        try {
            lock.lock();
            while (size >= initSize) {
                notFull.await();
            }
            items[size] = object;
            notEmpty.signal();
            size++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public Object take() {
        try {
            lock.lock();
            Object o;
            while (size == 0) {
                notEmpty.await();
            }
            o = items[size - 1];
            size--;
            notFull.signal();
            return o;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new BlockingQueue<String>(3);
        new Thread(() -> {
            System.out.println(blockingQueue.take());
        }, "A").start();

        TimeUnit.SECONDS.sleep(10);

        new Thread(() -> {
            blockingQueue.put("1231");
        }, "B").start();

    }
}


