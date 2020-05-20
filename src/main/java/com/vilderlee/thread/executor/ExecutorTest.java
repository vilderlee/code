package com.vilderlee.thread.executor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/12/31      Create this file
 * </pre>
 */
public class ExecutorTest {

    public static void main(String[] args) throws InterruptedException {
//        ExecutorService service = new ThreadPoolExecutor(2, 2,
//
//                0L, TimeUnit.MILLISECONDS,
//
//                new LinkedAtomicBoolean<>()) {
//
//            @Override protected void afterExecute(Runnable r, Throwable t) {
//                super.afterExecute(r, t);
//                System.out.println("omg!" + t);
//                printException(r);
//            }
//        };

        ExecutorService service = Executors.newFixedThreadPool(3);

        CountDownLatch countDownLatch = new CountDownLatch(20);
        AtomicBoolean flag = new AtomicBoolean();
        for (int i = 0; i < 20; i++) {
            Resource resource = new Resource(i, countDownLatch, flag);
            try{
            service.execute(resource);}catch (Exception e){
                e.printStackTrace();
                System.out.println("--------------");
            }
        }

        countDownLatch.await();

        if (flag.get()) {
            System.out.println("开始进行支付交易");
        } else {
            service.shutdown();
            throw new RuntimeException("交易出错");
        }


    }


    static class Resource implements Runnable {

        private int x;
        private CountDownLatch countDownLatch;
        private AtomicBoolean b;

        public Resource(int x, CountDownLatch countDownLatch, AtomicBoolean b) {
            this.x = x;
            this.countDownLatch = countDownLatch;
            this.b = b;
        }

        @Override
        public void run() {

            try {
                System.out.println(Thread.currentThread().getName() +"sleep " + 100);
                TimeUnit.MILLISECONDS.sleep(100);
                if (x == 3) {
                    throw new RuntimeException(Thread.currentThread().getName() + "  Iall!");
                }

                System.out.println(Thread.currentThread().getName() + "  " + x);
            }catch (Exception ex){
                ex.printStackTrace();
                b.set(false);
            }finally {
                countDownLatch.countDown();
            }
        }
    }





    private static void printException(Runnable r) {
        if (r instanceof Future<?>) {
            try {

                Future<?> future = (Future<?>) r;

                if (future.isDone()) {
                    future.get();
                }
            } catch (ExecutionException | InterruptedException ee) {
                System.out.println(ee.getMessage());
                System.out.println("数据执行异常!!!");
            }
        }
    }
}
