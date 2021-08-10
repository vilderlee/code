package com.vilderlee.java8.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * PredicateTest
 *
 * @ClassName PredicateTest
 * @Description
 * @Author VilderLee
 * @Date 2021/4/8 7:49 下午
 */

public class PredicateTest {

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> results = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                results.add(t);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        System.out.println(filter(Arrays.asList("123", "456"), (String s) -> s.equals("123")));
    }
}


