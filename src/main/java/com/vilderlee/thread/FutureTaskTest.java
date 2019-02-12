package com.vilderlee.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * Future + callable使用 线程池返回对象Future
 *
 * FutureTask + callable使用 FutureTask为线程池执行参数
 *
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2018/12/18      Create this file
 * </pre>
 */
public class FutureTaskTest implements Callable {
    private static ExecutorService executor = new ThreadPoolExecutor(3, 3, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

    @Override public String call() throws Exception {
        int i = 0;
        while(i<10){
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
        Future future = executor.submit(new FutureTaskTest());
        TimeUnit.SECONDS.sleep(10);
        executor.shutdown();
        System.out.println(future.get());

        ExecutorService executor = Executors.newCachedThreadPool();
        FutureTaskTest task = new FutureTaskTest();
        Future<Integer> result = executor.submit(task);
        executor.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            System.out.println("task运行结果"+result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");



    }
}
