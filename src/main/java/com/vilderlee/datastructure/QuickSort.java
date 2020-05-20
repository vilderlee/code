package com.vilderlee.datastructure;

import java.util.Arrays;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2020/1/16      Create this file
 * </pre>
 */
public class QuickSort {

    public static void quickSort(int[]arrays, int start , int end){
        if (arrays.length == 0 || start >= end){
            return;
        }
        int left = start;
        int right = end;
        int tmp = arrays[start];
        while (left!=right){
            while (left<right && arrays[right] >= tmp){
                right--;
            }
            while (left<right && arrays[left]<=tmp){
                left++;
            }
            if (left < right){
                int x = arrays[left];
                arrays[left] = arrays[right];
                arrays[right] = x;
            }
        }

        arrays[start] = arrays[left];
        arrays[left] = tmp;
        quickSort(arrays, start, left-1);
        quickSort(arrays, left + 1, end);
    }

    public static void main(String[] args) {
        int[] nums = { 5, 1, 3, 2, 8, 7, 4 };
        quickSort(nums, 0 ,nums.length-1);
        Arrays.stream(nums).forEach((i) -> System.out.print(i + ","));
    }
}
