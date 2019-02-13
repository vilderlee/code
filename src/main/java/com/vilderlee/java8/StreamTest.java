package com.vilderlee.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/2/13      Create this file
 * </pre>
 */
public class StreamTest {
    public static void main(String[] args) {
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        item1.setAmout(100L).setName("Lee");
        item2.setAmout(10000L).setName("Lee");
        item3.setAmout(20000L).setName("chao");
        List<Item> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);

        List<Item> filterList = list.stream().filter(item -> item.getName().equals("Lee")).collect(Collectors.toList());
        filterList.forEach(StreamTest::print);



        List<Item> limitList = list.stream().limit(3).collect(Collectors.toList());
        limitList.forEach(StreamTest::print);

        System.out.println(list.stream().mapToLong(Item::getAmout).summaryStatistics().getSum());
        System.out.println("Count:"+list.stream().mapToLong(Item::getAmout).sum());
    }


    private static void print(Item i){
        System.out.println(i.getName() + ":" +i.getAmout());
    }
}
