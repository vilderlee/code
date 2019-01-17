package com.vilderlee.collection.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2018/12/10      Create this file
 * </pre>
 */
public class TreeMapTest {

    public static void main(String[] args) {

        TreeMap treeMap = new TreeMap();

        treeMap.put("2", "b");
        treeMap.put("1", "a");
        treeMap.put("3", "c");
        treeMap.put(null, "d");
        treeMap.put("5", null);

        treeMap.forEach((k, v) -> {
            System.out.println("key:" + k + ",value:" + v);
        });

        System.out.println("----------------------------------------------");

        Comparator<Integer> comparator = (integer1, integer2) -> {
            if (integer1.compareTo(integer2) > 0) {
                return -1;
            } else if (integer1.compareTo(integer2) == 0) {
                return 0;
            } else {
                return 1;
            }
        };

        TreeMap treeMap1 = new TreeMap(comparator);

        treeMap1.put(2, "b");
        treeMap1.put(1, "a");
        treeMap1.put(3, "c");
        treeMap1.put(3, "d");
        treeMap1.put(null, "e");
        treeMap1.forEach((k, v) -> {
            System.out.println("key:" + k + ",value:" + v);
        });

        System.out.println(treeMap1.get(3));
        System.out.println(treeMap1.size());

    }
}
