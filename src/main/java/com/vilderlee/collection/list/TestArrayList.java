package com.vilderlee.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/11      Create this file
 * </pre>
 */
public class TestArrayList {

    public static void main(String[] args) throws Exception {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("VilderLee");


        for (int i = 1; i <= (arrayList.size() + 2 - 1) /2; i++) {
            List subList;
            if (2 * i > arrayList.size()) {
                subList = arrayList.subList((i - 1) * 2, arrayList.size());
            }else {
                subList = arrayList.subList((i - 1) * 2, 2 * i);
            }

            System.out.println("----" + i + "----");
            subList.forEach(item -> System.out.println(item));
        }

    }

}
