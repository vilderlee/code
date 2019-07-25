package com.vilderlee.datastructure.sort;

import java.util.Arrays;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/25      Create this file
 * </pre>
 */
public class BubbleSort {

    /**
     * 冒泡排序 依次比较两个相邻的元素
     * 在上面的五个数字中 12 8 17 31 22
     *
     * @param nums
     * @return
     */
    public static int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        Arrays.stream(bubbleSort(new int[] { 23, 12, 34, 2, 67 })).forEach((i) -> System.out.print(i + ","));
    }
}
