package com.vilderlee.gc;

import java.lang.ref.SoftReference;
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
        WeakReference<Object> softReference = new WeakReference(Object.class);
        System.out.println(task);

        System.out.println(softReference.get());

        System.gc();

        System.out.println(softReference.get()+"11111111111");
        try {
            byte[] bytes = new byte[1 * 1024 * 1024];
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println(task);

            System.out.println(softReference.get());
        }
    }
}