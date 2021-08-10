package com.vilderlee.java8.function;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * OptionalTest
 *
 * @ClassName OptionalTest
 * @Description
 * @Author VilderLee
 * @Date 2021/4/8 9:30 下午
 */

public class OptionalTest {
    public static void main(String[] args) {
        final List<String> strings = Arrays.asList("lichao", "vilderlee", "vilderli");

        System.out.println(strings.stream().filter(s -> s.equals("123")).findAny().orElse("yaoxi"));

        int[] nums = new int[]{1, 2, 3};
        System.out.println(Arrays.stream(nums).reduce(1, (a, b) -> a + b));

        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t-> t[0])
                .forEach(System.out::print);
    }

}
