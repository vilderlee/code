package com.vilderlee.collection.map;

import java.util.LinkedHashMap;
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
public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("1", "a");
        map.put("3", "c");
        map.put("2", "b");

        map.put("4", "d");
        map.put("5", "e");
        map.put(null, null);

        map.forEach((k, v) -> {
            System.out.println("Key:" + k + " , " + "Value:" + v);
        });

        Set<Map.Entry<String, String>> entries = map.entrySet();



    }
}
