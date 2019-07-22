package com.vilderlee.thread.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

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
public class AtomicQuestion {
    public static void main(String[] args) {

        int i = 0;
        AtomicStampedReference stampedReference = new AtomicStampedReference(i,0);
        stampedReference.compareAndSet(1,5,0,1);

        System.out.println(stampedReference.getReference());
    }
}
