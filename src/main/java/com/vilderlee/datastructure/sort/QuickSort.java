package com.vilderlee.datastructure.sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

        while (left != right) {
            //从右边开始找到比基准小的数据
            while (left < right && nums[right] > tmp) {
                right--;
            }
            //把这个数据移到左边
            nums[left] = nums[right];
            //从左边开始找到比基准大的数据
            while (left < right && nums[left] < tmp) {
                left++;
            }
            //把这个数据移到右边
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

        if (low == high) {
            return;
        }

        int left = low;
        int right = high;
        int tmp = nums[left];
        while (left != right) {
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

    public static void quick3(int nums[], int low, int high) {
        if (nums.length == 0 || low >= high) {
            return;
        }
        int left = low;
        int right = high;
        int tmp = nums[low];
        while (left != right) {
            while (left < right && nums[right] >= tmp) {
                right--;
            }

            while (left < right && nums[left] <= tmp) {
                left++;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }

        nums[low] = nums[left];
        nums[left] = tmp;
        quick3(nums, low, left - 1);
        quick3(nums, left + 1, high);

    }

    private static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }

    public static void quickSort4(int[] nums, int start, int end) {
        if (nums.length == 0 || start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int provior = nums[start];
        while (left != right) {
            while (left < right && nums[right] >= provior) {
                right--;
            }
            while (left < right && nums[left] <= provior) {
                left++;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }

        nums[start] = nums[left];
        nums[left] = provior;

        quickSort4(nums, start, left - 1);
        quickSort4(nums, left + 1, end);
    }

    /**
     * 获得金矿最优收益
     *
     * @param w 工人数量
     * @param n 可选金矿数量
     * @param p 金矿开采所需的工人数量
     * @param g 金矿储量
     */
    public static int getBestGoldMining(int w, int n, int[] p, int[] g) {
        if (w == 0 || n == 0) {
            return 0;
        }

        if (w < p[n - 1]) {
            getBestGoldMining(w, n - 1, p, g);
        }

        return Math.max(getBestGoldMining(w, n - 1, p, g), getBestGoldMining(w - p[n - 1], n - 1, p, g) + g[n - 1]);

    }

    public static int fbnacii(int x) {

        if (x <= 1) {
            return x;
        }
        int x1 = 0;
        int x2 = 1;
        int result = 0;
        for (int i = 2; i <= x; i++) {
            result = x1 + x2;
            x1 = x2;
            x2 = result;
        }
        return result;
    }

    public static List<List<String>> partition(String s, int start) {
        int length = s.length();
        if (length == 0) {
            return null;
        }
        List<List<String>> res = new ArrayList<>();
        for (int i = start; i < length; i++) {
            String substring = s.substring(start, i + 1);
            if (isPalindrome(substring)) {
                List<String> list = new ArrayList<>();
                //判断后面的是不是

            }
        }
        return null;
    }

    private static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 示例:
     * <p>
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int sum = sum(nums, j, i);
                res = Math.max(sum, res);
            }
        }
        return res;
    }

    public int sum(int[] nums, int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            res += nums[i];
        }
        return res;
    }

    public int climbStairs(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 注意你不能在买入股票前卖出股票。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     * 示例 2:
     * <p>
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     * @param prices
     */
    public static int maxProfit(int[] prices) {

        int max = 0;
        int min = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }

        return max;
    }

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        if (nums.length==0){return 0;}
        dp[0] =0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i-1], dp[i-1]);
        }

        return dp[nums.length];
    }

    public static void main(String[] args) {

        //        int[] nums = { 5, 1, 3, 2, 8, 7, 4 };
        //        //        quick3(nums, 0 ,nums.length-1);
        //        quickSort4(nums, 0, nums.length - 1);
        //        Arrays.stream(nums).forEach((i) -> System.out.print(i + ","));
        System.out.println(isPalindrome("aba"));
        System.out.println(rob(new int[] {2,1,1,2}));
    }
}
