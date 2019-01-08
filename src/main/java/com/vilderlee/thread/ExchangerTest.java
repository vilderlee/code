package com.vilderlee.thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
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
public class ExchangerTest {
    private static final Exchanger<String> exchanger = new Exchanger<>();

    private static ExecutorService executor = new ThreadPoolExecutor(2, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

    public static void main(String[] args) {
        executor.execute(new Runnable() {
            @Override public void run() {
                String a = "lichao";
                Thread.currentThread().setName("lichao");
                try {
                  String b = exchanger.exchange(a);
                    System.out.println(Thread.currentThread().getName() + "--" + b);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.execute(new Runnable() {
            @Override public void run() {
                String b = "wangzhao";

                try {
                  String a = exchanger.exchange(b);
                    Thread.currentThread().setName("wangzhao");
                    System.out.println(Thread.currentThread().getName() + "++" + a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.shutdown();
    }
}
