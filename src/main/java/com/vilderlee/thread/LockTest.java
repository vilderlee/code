package com.vilderlee.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/6/17      Create this file
 * </pre>
 */
public class LockTest {

    public static void main(String[] args) throws Exception {
        SubjectDomain subjectDomain = new SubjectDomain();
        Runnable read = () -> {
            try {
                subjectDomain.take();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Runnable write = () -> {
            try {
                Thread.sleep(10000);
                subjectDomain.put(3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        new Thread(read).start();

        new Thread(write).start();

    }

    private static class SubjectDomain {
        private Lock lock = new ReentrantLock();
        private Condition write = lock.newCondition();
        private Condition read = lock.newCondition();

        private List<Integer> nums = new ArrayList<>();

        private final int max = 10;

        public void put(int i) throws Exception {
            lock.lock();
            System.out.println("放入数据---");

            try {
                if (nums.size() > max) {
                    System.out.println("list.size > max");
                    write.await();
                }
                nums.add(i);
                read.signal();

            } finally {
                lock.unlock();
            }
        }

        public void take() throws Exception {
            lock.lock();
            System.out.println("读取数据---");
            int i = 0;
            try {
                if (nums.isEmpty()) {
                    System.out.println("list.size == 0");
                    read.await();
                    System.out.println("await===");
                }
                i = nums.get(0);
                write.signal();
            } finally {
                lock.unlock();
            }

            System.out.println(i);
        }
    }

}
