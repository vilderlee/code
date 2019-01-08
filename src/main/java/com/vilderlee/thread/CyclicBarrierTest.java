package com.vilderlee.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2018/12/18      Create this file
 * </pre>
 */
public class CyclicBarrierTest implements Runnable {
    CyclicBarrier cyclicBarrier;
    int i;

    public CyclicBarrierTest(CyclicBarrier cyclicBarrier, int i) {
        this.cyclicBarrier = cyclicBarrier;
        this.i = i;
    }

    @Override public void run() {
        System.out.println(Thread.currentThread().getName() + "--" + "执行");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "--" + "执行结束");
    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        // 下载对账文件的线程池
        ExecutorService downloadBankStatementThreadPool = Executors.newFixedThreadPool(2);
        CyclicBarrierTest cyclicBarrierTest = new CyclicBarrierTest(cyclicBarrier, 10);
        for (int i = 0; i < 2; i++) {
            downloadBankStatementThreadPool.execute(new CyclicBarrierTest(cyclicBarrier,1));
            downloadBankStatementThreadPool.execute(new CyclicBarrierTest(cyclicBarrier,2));
            System.out.println("Main------------------------end");
//            cyclicBarrier.reset();
        }

        System.out.println("end");
    }
}
