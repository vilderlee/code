package com.vilderlee.gc;

import java.lang.ref.WeakReference;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/25      Create this file
 * </pre>
 */
public class WeakReferenceQuestion {

    public static void main(String[] args) {
        Object task = new Object();
        WeakReference<Object> weakReference = new WeakReference(task);
        System.out.println(task);

        System.out.println(weakReference.get());
        task = null;
        System.gc();
        System.out.println(task);

        System.out.println(weakReference.get());
    }
}