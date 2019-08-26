package com.vilderlee.thread.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/29      Create this file
 * </pre>
 */
public class RejectPolicy {

    public static void main(String[] args) {

        RejectedExecutionHandler rejectedExecutionHandler =  new ThreadPoolExecutor.AbortPolicy();

        ExecutorService executor = new ThreadPoolExecutor(3, 3, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(), rejectedExecutionHandler);


    }
}
