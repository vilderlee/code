package com.vilderlee.thread;

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
public class WaitQuestion {

    public static void main(String[] args) {

        Thread thread1 = new Thread(WaitQuestion::action, "t1");
        Thread thread2 = new Thread(WaitQuestion::action, "t2");
        Thread thread3 = new Thread(WaitQuestion::action, "t3");

        thread1.start();
        while (thread1.isAlive()) {
        }
        thread2.start();
        while (thread2.isAlive()) {
        }
        thread3.start();
    }

    private static void threadStartAndWait(Thread thread) {
        if (thread.getState() == Thread.State.NEW) {
            thread.start();
        }

        while (thread.isAlive()) {
            synchronized (thread) {
                try {
                    thread.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void action() {
        System.out.printf("线程[%s] 正在执行...\n", Thread.currentThread().getName());
    }

}
