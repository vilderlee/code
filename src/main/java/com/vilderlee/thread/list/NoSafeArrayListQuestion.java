package com.vilderlee.thread.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

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
public class NoSafeArrayListQuestion {
    public static void main(String[] args) throws InterruptedException {
        List list = new CopyOnWriteArrayList();
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                Random random = new Random();

                list.add(random.nextInt());
                countDownLatch.countDown();
//                System.out.println(list);
            }).start();
        }

        countDownLatch.await();
        System.out.println(list);
    }
}
