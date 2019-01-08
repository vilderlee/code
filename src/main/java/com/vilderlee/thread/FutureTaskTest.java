package com.vilderlee.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2018/12/18      Create this file
 * </pre>
 */
public class FutureTaskTest implements Callable {
    private static ExecutorService executor = new ThreadPoolExecutor(3, 3, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

    @Override public Object call() throws Exception {
        int i = 0;
        while(i<1000000){
            System.out.println(i);
            i++;
        }
        return Thread.currentThread().getName() + i;
    }

    class RunnableTest implements Runnable{
        @Override public void run() {
            for (int i = 0; i < 1000000; i++) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask futureTask = new FutureTask(new FutureTaskTest());
        executor.submit(futureTask);

        Future future1 = executor.submit(futureTask);
        Thread.sleep(10);
        future1.cancel(true);
        System.out.println(future1.get());
    }
}
