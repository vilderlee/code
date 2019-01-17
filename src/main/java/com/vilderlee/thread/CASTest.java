package com.vilderlee.thread;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/17      Create this file
 * </pre>
 */
public class CASTest {
    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.compareAndSet(0, 1);
        System.out.println(atomicInteger);
    }
}
