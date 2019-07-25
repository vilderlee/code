package com.vilderlee.collection.list;

import org.apache.commons.collections.map.HashedMap;

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
 * VilderLee    2019/4/16      Create this file
 * </pre>
 */
public class StreamTest {

    public static void main(String[] args) {
        Person p1 = new Person("1", "lichao1");
        Person p2 = new Person("2", "lichao2");
        Person p3 = new Person("3", "lichao3");
        Person p4 = new Person("4", "lichao4");

        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        Map<String, Person> map = new HashMap<>(list.size());
        map = list.stream().collect(Collectors.toMap(Person::getId,person -> person ));

        map.get("2").setName("tianne");

        System.out.println(map);
    }
}
