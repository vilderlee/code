package com.vilderlee.gc;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/25      Create this file
 * </pre>
 * <p>
 * <p>
 * GCCommand: -Xmx10m -Xms10m -Xmn5m -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=10m
 *            -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
 *            -Xloggc:gc.log
 */
public class GCDetails {
    public static void main(String[] args) {

        //生成了3M对象，Eden区一共4M，当2M对象生成以后，Eden区无法放下，这时，
        //触发MGC
        byte[] array1 = new byte[1024 * 1024];
        array1 = new byte[1024 * 1024];
        array1 = new byte[1024 * 1024];
        array1 = null;

        byte[] array2 = new byte[1000 * 1024 * 1024];

//        System.gc();

    }
}
