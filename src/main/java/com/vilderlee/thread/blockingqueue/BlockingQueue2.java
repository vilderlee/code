package com.vilderlee.thread.blockingqueue;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

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
public class BlockingQueue2<T> {

    private volatile int size = 0;
    private final int initSize;
    private final Object monitor = new Object();

    private Object[] items;

    public BlockingQueue2(int initSize) {
        this.initSize = initSize;
        items = new Object[initSize];
    }

    public void put(Object object) throws Exception {
        System.out.println(Thread.currentThread().getName() + "放入元素" + object);

        synchronized (monitor) {
            while (size >= initSize) {
                monitor.wait();
            }

            items[size] = object;
            monitor.notifyAll();
            size++;
        }
        System.out.println(Thread.currentThread().getName() + "元素" + size);

    }

    public Object take() throws InterruptedException {
        synchronized (monitor) {
            Object o;
            while (size == 0) {
                monitor.wait();
            }
            o = items[size - 1];
            size--;
            monitor.notifyAll();
            return o;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue2 blockingQueue = new BlockingQueue2<String>(3);
//        new Thread(() -> {
//            try {
//                System.out.println(blockingQueue.take());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, "A").start();
//
//        TimeUnit.SECONDS.sleep(10);

        for (int i = 0; i < 4; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    blockingQueue.put(String.valueOf(finalI));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }


    }
}


