package com.vilderlee.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2018/12/18      Create this file
 * </pre>
 */
public class SemphoreTest implements Runnable {
    Semaphore semaphore;

    public SemphoreTest(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override public void run() {
        try {
//            System.out.println(Thread.currentThread().getName() + "尝试取得" + semaphore.tryAcquire(3));
            System.out.println("-----"+semaphore.availablePermits());
            System.out.println(Thread.currentThread().getName() + "--取得");
            semaphore.acquire(5);
            System.out.println(semaphore.availablePermits());
            System.out.println(Thread.currentThread().getName() + "--释放");
            semaphore.release(2);

            System.out.println(semaphore.availablePermits());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(1);
        Semaphore semaphore = new Semaphore(3);

        SemphoreTest semphoreTest = new SemphoreTest(semaphore);
        executor.execute(semphoreTest);

    }
}
