package com.vilderlee.compare;

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
public class Compare {

    public static void main(String[] args) {
        Map hashMap = new HashMap();
        hashMap.put("1", "a");
        hashMap.put("2", "b");
        hashMap.put("3", "c");
        hashMap.forEach((k,v)->{
            System.out.println(v);
        });

        System.out.println("----------------------------------------------");

        TreeMap treeMap = new TreeMap();
        treeMap.put("2", "b");
        treeMap.put("1", "a");
        treeMap.put("3", "c");

        treeMap.forEach((k,v)->{
            System.out.println("key:" + k + ",value:" + v);
        });

        System.out.println("----------------------------------------------");

        TreeMap treeMap1 = new TreeMap((Object o1, Object o2)->{


            if ((Integer)o1>(Integer)o2){
                return -1;
            }else if (((Integer)o1).equals((Integer)o2)){
                return 0;
            }else {
                return -1;
            }
        });

        treeMap1.put(2, "b");
        treeMap1.put(1, "a");
        treeMap1.put(3, "c");
        treeMap1.forEach((k,v)-> {
            System.out.println("key:" + k + ",value:" + v);
        });
    }
}
