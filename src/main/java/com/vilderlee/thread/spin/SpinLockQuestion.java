package com.vilderlee.thread.spin;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/22      Create this file
 * </pre>
 */
public class SpinLockQuestion {

    private AtomicReference<Thread> atomicReference = new AtomicReference();

    public void lock() {
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void unlock() {
        atomicReference.set(null);
    }
    public static void main(String[] args) throws InterruptedException {
//        CountDownLatch countDownLatch = new CountDownLatch(1000);
        Task task = new Task();

//        Thread t1=   new Thread(() -> {
//                task.add();
//            },"t1");
//
//        Thread t2=   new Thread(() -> {
//            task.add();
//        },"t2");
//
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();


        //        Thread main = Thread.currentThread();
        //
        //        //获取线程组
        //        ThreadGroup group = main.getThreadGroup();
        //        //获取活跃的线程数
        //        int activeCount = group.activeCount();
        //        Thread[] threads = new Thread[activeCount];
        //        group.enumerate(threads);
        //
        //        Stream.of(threads).forEach(thread -> System.out.println(thread.getName()));
//        countDownLatch.await();

        for (int i = 0; i < 1000000; i++) {
            new Thread(() -> {
                task.add();
            }).start();

        }
        TimeUnit.SECONDS.sleep(20);
        System.out.println(Thread.currentThread().getName() + task.i);

    }


}
class Task {
    private final SpinLockQuestion spinLockQuestion = new SpinLockQuestion();

    public int i = 0;
    CountDownLatch countDownLatch;

    public void add() {
        spinLockQuestion.lock();
        int idx=0;
//        while (idx++<10000){

           i++;
//        }

//        System.out.println(Thread.currentThread().getName() + "---"+ i);
        spinLockQuestion.unlock();
    }

}