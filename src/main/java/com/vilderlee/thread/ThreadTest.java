package com.vilderlee.thread;

import java.util.concurrent.TimeUnit;

/**
 * 功能描述:
 *
 * @package com.vilderlee.thread
 * @auther vilderlee
 * @date 2019-01-12 14:39
 */
public class ThreadTest {
    class Test implements Runnable{

        private int i;

        public Test(int i) {
            this.i = i;
        }

        @Override public void run() {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        Test test = threadTest.new Test(1);
        Thread thread = new Thread(test);
        thread.start();
        thread.start();
        thread.start();
    }
}
