package com.vilderlee.collection;

import java.util.ArrayList;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/11      Create this file
 * </pre>
 */
public class TestArrayList {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("VilderLee");
        arrayList.add(0,"DougLea");
        arrayList.remove(0);
        arrayList.remove("");

        arrayList.iterator();

        String firstString = arrayList.get(0);
        System.out.println(firstString);

    }
}
