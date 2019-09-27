package com.vilderlee.thread.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/9/11      Create this file
 * </pre>
 */
public class CompletableFutureTest {

    public static void main(String[] args) {
        CompletableFuture f1 = CompletableFuture.runAsync(() -> {
            System.out.println("T1:洗水壶。。。");
            sleep(1, TimeUnit.SECONDS);

            System.out.println("T1:烧开水。。。");
            sleep(15, TimeUnit.SECONDS);
        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("T2:洗茶壶。。。");
            sleep(1, TimeUnit.SECONDS);

            System.out.println("T2:洗茶杯。。。");
            sleep(2, TimeUnit.SECONDS);

            System.out.println("T2:拿茶叶。。。");
            sleep(1, TimeUnit.SECONDS);
            return "龙井";
        });

        CompletableFuture<String> f3 = f1.thenCombine(f2, (__, tf) -> {
            System.out.println("T1:拿到茶叶");
            System.out.println("T1:泡茶");
            return "上茶" + tf;
        });

        System.out.println(f3.join());

        CompletableFuture t1 = CompletableFuture.runAsync(() -> {
            System.out.println("T1:开始执行");
        }).thenRun(() -> {
            sleep(5, TimeUnit.SECONDS);
            System.out.println("T2:开始执行");
        }).thenRun(() -> {
            System.out.println("T3:开始执行");
        });

        t1.join();

    }

    private static void sleep(int i, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
