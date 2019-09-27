package com.vilderlee.datastructure.sort;

import java.util.Arrays;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/8/30      Create this file
 * </pre>
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = { 5, 8, 2, 9, 4, 7, 3 };
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <length-i-1; j++) {
                if (nums[j] > nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
        Arrays.stream(nums).forEach((i) -> System.out.print(i + ","));
    }
}
