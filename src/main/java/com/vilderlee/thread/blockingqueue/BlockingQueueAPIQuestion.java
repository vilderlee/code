package com.vilderlee.thread.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * 类说明:
 *  总结add remove会抛出异常
 *     offer poll会返回值
 *     put take会阻塞
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/29      Create this file
 * </pre>
 */
public class BlockingQueueAPIQuestion {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new SynchronousQueue();
        throwExceptionMethod(blockingQueue);

    }

    private static void blocking(BlockingQueue blockingQueue) throws InterruptedException {
        blockingQueue.put(1);
        blockingQueue.put(2);

        blockingQueue.take();
    }

    private static void returnBackValue(BlockingQueue blockingQueue) {
        System.out.println(blockingQueue.offer(1));
        System.out.println(blockingQueue.offer(1));

        System.out.println(blockingQueue.poll());
    }

    private static void throwExceptionMethod(BlockingQueue blockingQueue) {
        System.out.println(blockingQueue.add(1));
        System.out.println(blockingQueue.add(2));

        System.out.println(blockingQueue.remove());
    }
}
