package com.vilderlee.java8.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/4/28      Create this file
 * </pre>
 */
public class MapTest {
    public static void main(String[] args) {
        List<Item> list = new ArrayList<>();
        list.add(new Item("1", 1L, "cfca"));
        list.add(new Item("1", 2L, "cfca"));
        list.add(new Item("2", 3L, "cpcn"));
        list.add(new Item("2", 4L, "cpcn"));

        Map<String, List<Item>> map = list.stream().collect(Collectors.groupingBy(Item::getId));
        Map map1  = new HashMap();
        for (String a : map.keySet()) {
            List<Item> items = map.get(a);
            map1.put(a,items.stream().collect(Collectors.groupingBy(Item::getName)));
        }

        System.out.println(map1);
    }
}
