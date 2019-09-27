package com.vilderlee.datastructure.sort;

import redis.clients.util.Slowlog;

import java.util.Arrays;
import java.util.UUID;

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
public class QuickSort {

    public static void quickSort(int[] nums, int low, int high) {

        if (nums.length <= 0 || low >= high) {
            return;
        }

        int left = low;
        int right = high;
        //1 基准值
        int tmp = nums[left];

        while (left < right) {
            while (left < right && nums[right] > tmp) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] < tmp) {
                left++;
            }
            nums[right] = nums[left];
        }

        nums[left] = tmp;

        quickSort(nums, low, left - 1);
        quickSort(nums, left + 1, high);

    }

    public static void quick2(int[] nums, int low, int high) {
        if (null == nums || nums.length == 0) {
            return;
        }

        if (low > high) {
            return;
        }

        int left = low;
        int right = high;
        int tmp = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= tmp) {
                right--;
            }
            while (left < right && nums[left] <= tmp) {
                left++;
            }
            swap(nums, left, right);
        }
        swap(nums, low, left);
        quick2(nums, low, left - 1);
        quick2(nums, left + 1, high);
    }

    private static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {

        int[] nums = { 5, 1, 3, 2, 8 };
//        quickSort(nums, 0, 4);
        quick2(nums, 0, 4);

        Arrays.stream(nums).forEach((i) -> System.out.print(i + ","));
    }
}
