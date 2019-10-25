package com.vilderlee.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/10/24      Create this file
 * </pre>
 */
public class FlatMapTest {

    public static void main(String[] args) {
        List<String> words= Arrays.asList("Hello","World");
        List<String> collect = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        collect.forEach(System.out::println);

    }
}
