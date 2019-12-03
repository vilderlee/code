package com.vilderlee.thread.blockingqueue;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能描述:
 *
 * @package com.vilderlee.thread.blockingqueue
 * @auther vilderlee
 * @date 2019/11/3 7:18 下午
 */
public class ArrayBlocQueueDemo {
    public static void main(String[] args) throws IOException, InterruptedException {

        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue(10);

        new Thread(() -> {
            try {
                while (true) {
                    int num = queue.take();
                    System.out.println(num);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> { queue.add(1); }).start();
        new Thread(() -> { queue.add(2); }).start();
        new Thread(() -> { queue.add(3); }).start();
        new Thread(() -> { queue.add(4); }).start();


    }
}
