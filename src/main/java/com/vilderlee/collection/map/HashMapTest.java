package com.vilderlee.collection.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/16      Create this file
 * </pre>
 */
public class  HashMapTest {
    public static void main(String[] args) {

//        //允许空值、空键
//        Map map = new HashMap();
//        map.put("1", "a");
//        map.put("3", "c");
//        map.put("4", "d");
//        map.put("2", "b");
//
//        //        map.put("3", "z");
//
//        //        map.put(null, "w");
//        map.put("5", "e");
//
//        map.forEach((K, V) -> {
//            System.out.println("Key:" + K + ";Value:" + V);
//        });
//
//        System.out.println("----------------------------------------------");
//
//        map.putIfAbsent("5", "as");
//
//        map.forEach((K, V) -> {
//            System.out.println("Key:" + K + ";Value:" + V);
//        });
//        System.out.println("----------------------------------------------");

        Map table = new HashMap();
        table.put("1", "a");
        table.put("2", "b");
        table.put("3", "c");
        table.put("3", "z");
        //        table.put(null, "d");
        //        table.put(null, "w");
        //        table.put("5", null);
//        System.out.println(table.size());
//        System.out.println(table.get("3"));
//
        System.out.println(table.getOrDefault("1-" , 100));
        System.out.println("----------------------------------------------");





    }
}
