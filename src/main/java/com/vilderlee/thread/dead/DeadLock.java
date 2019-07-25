package com.vilderlee.thread.dead;

import java.util.concurrent.TimeUnit;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/6/13      Create this file
 * </pre>
 */
public class DeadLock {

    private static final Object object1 = new Object();
    private static final Object object2 = new Object();

    private static class Subject1 implements Runnable{

        @Override
        public void run() {
            synchronized (object1){
                try {
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println("thread1 synchronized obj1 and wait for obj2.");
                    synchronized (object2){
                        System.out.println("thread1 synchronized obj2");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private static class Subject2 implements Runnable{

        @Override
        public void run() {
            synchronized (object2){
                try {
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println("thread2 synchronized obj2 and wait for obj1.");
                    synchronized (object1){
                        System.out.println("thread1 synchronized obj2");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Subject1()).start();
        new Thread(new Subject2()).start();
    }

}
