package com.vilderlee.thread;

import com.alibaba.dubbo.common.utils.NamedThreadFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/4/3      Create this file
 * </pre>
 */
public class NewExecutors {
    public static void main(String[] args) {
        String threadName = "testFactory";

        ProcessThreadFactory processThreadFactory = new ProcessThreadFactory("123");
        ExecutorService executor = new ThreadPoolExecutor(0, 5, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3),
                processThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        Task task = new Task("VilderLee");
        executor.execute(task);

    }


    static class ProcessThreadFactory implements ThreadFactory {
        private final ThreadGroup group;
        private final String namePrefix;

        ProcessThreadFactory(String institutionID) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = "Process-" + institutionID + "-Thread-";
        }

        @Override public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r, namePrefix, 0);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }


    static class Task implements Runnable{

        private String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {

            System.out.println("Test:" + name + ":" + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
            }

        }
    }
}
