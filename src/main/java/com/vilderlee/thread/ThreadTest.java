package com.vilderlee.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/5/20      Create this file
 * </pre>
 */
public class ThreadTest implements Runnable {


    private boolean flag = false;

    @Override public void run() {
        if (!flag){
            synchronized (this){
                try{

                if (!flag){
                    flag = true;
                    System.out.println("DoThis!");

                }}catch (Exception e){
                    e.printStackTrace();
                }finally {
                    flag = false;
                }
            }
        }else {
            System.out.println("job is running!");
        }
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        NewExecutors.ProcessThreadFactory processThreadFactory = new NewExecutors.ProcessThreadFactory("123");
        ExecutorService executor = new ThreadPoolExecutor(0, 5, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3),
                processThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            executor.execute(threadTest);
        }
    }
}
