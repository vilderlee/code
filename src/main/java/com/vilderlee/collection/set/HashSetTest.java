package com.vilderlee.collection.set;

import java.util.HashSet;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/16      Create this file
 * </pre>
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add(null);
        set.add(1);

        System.out.println(set.size());
    }
}
