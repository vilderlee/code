package com.vilderlee.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2018/12/18      Create this file
 * </pre>
 *
 * CountDownLatch相当于每个线程做完自己的事情，然后再做事
 * CyclicBarrier相当于每个线程阻塞到await位置，当n个线程到了之后，再分别做自己的事情。
 *
 */
public class CountDownLatchTest implements Runnable {

    private CountDownLatch countDownLatch;
    private String name;

    public CountDownLatchTest(CountDownLatch countDownLatch,String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    public static void main(String[] args) {
        ExecutorService downloadBankStatementThreadPool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 3; i++) {
            CountDownLatch countDownLatch = new CountDownLatch(2);
            downloadBankStatementThreadPool.execute(new CountDownLatchTest(countDownLatch,"active"));
            downloadBankStatementThreadPool.execute(new CountDownLatchTest(countDownLatch,"passive"));

            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("第"+i +"次执行结束");
        }
        downloadBankStatementThreadPool.shutdown();
    }

    @Override
    public void run() {
        System.out.println("name:" + Thread.currentThread().getName());
        System.out.println("name:" + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }
}
