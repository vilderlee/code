package com.vilderlee.collection.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/16      Create this file
 * </pre>
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap map = new LinkedHashMap();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        map.put("5", "e");

        map.forEach((k, v) -> {
            System.out.println("Key:" + k + " , " + "Value:" + v);
        });
    }
}
