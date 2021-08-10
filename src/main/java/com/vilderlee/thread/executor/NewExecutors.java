package com.vilderlee.thread.executor;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

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
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        String threadName = "testFactory";

        ProcessThreadFactory processThreadFactory = new ProcessThreadFactory("123");
        ExecutorService executor = new ThreadPoolExecutor(3, 5, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(3),
                processThreadFactory, new ThreadPoolExecutor.AbortPolicy());


        List<Future> list = new ArrayList<>();
        CountDownLatch c = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Task task = new Task(c, "VilderLee");
            Future<String> f = executor.submit(task);
            list.add(f);
        }
        if (!c.await(20, TimeUnit.SECONDS)) {
            System.out.println("456456");
        }

        for (Future f : list) {
            System.out.println(f.get());
        }

        System.out.println("123213123123");
    }


    public static class ProcessThreadFactory implements ThreadFactory {
        private final ThreadGroup group;
        private final String namePrefix;

        public ProcessThreadFactory(String institutionID) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = "Process-" + institutionID + "-Thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
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


    static class Task implements Callable<String> {

        private String name;

        private CountDownLatch c;

        public Task(CountDownLatch c, String name) {
            this.name = name;
            this.c = c;
        }

        @Override
        public String call() {
            try {
                System.out.println("Test:" + name + ":" + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(10);
                return "Test123:" + name + ":" + Thread.currentThread().getName();
            } catch (Exception e) {
                return "null";
            } finally {
                c.countDown();
            }
        }
    }
}
