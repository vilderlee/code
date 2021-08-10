package com.vilderlee.datastructure.array;

/**
 * PivotIndex
 *
 * @ClassName PivotIndex
 * @Description
 * @Author VilderLee
 * @Date 2021/3/8 10:46 上午
 */

public class PivotIndex {

    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - nums[i] - leftSum) {
                return i;
            }
            leftSum += leftSum;
        }
        return -1;
    }

    public static int pivotIndex2(int[] nums, int m, int n) {
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = nums[i] + prefixSum[i];
        }
        return prefixSum[n + 1] - prefixSum[m];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 7, 9, 11};
        System.out.println(pivotIndex2(nums, 2, 5));
    }
}
