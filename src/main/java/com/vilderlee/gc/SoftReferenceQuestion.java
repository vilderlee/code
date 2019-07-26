package com.vilderlee.gc;

import java.lang.ref.SoftReference;

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
public class SoftReferenceQuestion {



    public static void main(String[] args) {
        Object task = new Object();
        SoftReference<Object> softReference = new SoftReference(task);
        System.out.println(task);

        System.out.println(softReference.get());

        task = null;
        try {
            byte[] bytes = new byte[10 * 1024 * 1024];
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println(task);

            System.out.println(softReference.get());
        }
    }
}