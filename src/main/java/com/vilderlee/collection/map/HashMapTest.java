package com.vilderlee.collection.map;

import com.vilderlee.dataStructure.heap.KthLargest;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/16      Create this file
 * </pre>
 */
public class HashMapTest {
    public static void main(String[] args) {

        //允许空值、空键
        Map map = new HashMap();
        map.put("1", "a");
        map.put("3", "c");
        map.put("2", "b");

        //        map.put("3", "z");
        map.put("4", "d");
        //        map.put(null, "w");
        map.put("5", "e");

        map.forEach((K, V) -> {
            System.out.println("Key:" + K + ";Value:" + V);
        });


        System.out.println("----------------------------------------------");

        map.putIfAbsent("5", "as");

        map.forEach((K, V) -> {
            System.out.println("Key:" + K + ";Value:" + V);
        });
        System.out.println("----------------------------------------------");


        Map table = new Hashtable();
        table.put("1", "a");
        table.put("2", "b");
        table.put("3", "c");
        table.put("3", "z");
        //        table.put(null, "d");
        //        table.put(null, "w");
        //        table.put("5", null);
        System.out.println(table.size());
        System.out.println(table.get("3"));
        System.out.println("----------------------------------------------");
    }
}
