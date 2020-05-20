package com.vilderlee.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2020/1/17      Create this file
 * </pre>
 */
public class FindLongestString {
    public static int findLongestString(String string) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, res = 0;
        while (i < string.length() && j < string.length()) {
            if (!set.contains(string.charAt(j))) {
                set.add(string.charAt(j++));
                res = Math.max(res, j - i);
            } else {
                set.remove(string.charAt(i++));
            }
        }

        return res;
    }

    public static boolean findKey(int[] array, int key) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == key) {
                return true;
            }
            if (array[mid] > key) {
                end = mid - 1;
            }
            if (array[mid] < key) {
                start = mid + 1;
            }

        }

        return false;
    }

    public static int findOne(int[] nums) {
        int x = 0;
        for (int i = 0; i < nums.length; i++) {

            int count = 1;
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            for (int j = 0; j <= i - 1; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count == 1) {
                x = nums[i];
                break;
            }
        }
        return x;
    }

    public static int findOne2(int[] nums) {
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            x = x ^ nums[i];
        }
        return x;
    }

    public static int mostNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int tmp = (nums.length & 1) == 1 ? nums.length / 2 + 1 : nums.length / 2;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {

                if (map.get(nums[i]) + 1 >= tmp) {
                    return nums[i];
                } else {
                    map.put(nums[i], map.get(nums[i]) + 1);
                }
            } else {
                map.put(nums[i], 1);
            }
        }
        return 0;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix == null) {
            return false;
        }

        if (matrix.length == 1 && matrix[0][0] == target) {
            return true;
        }

        int high = 0;
        int width = matrix[0].length - 1;
        while (width >= 0 && high <= matrix[0].length - 1) {
            if (matrix[high][width] > target) {
                width--;
            } else if (matrix[high][width] < target) {
                high++;
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     * <p>
     * 说明:
     * <p>
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * 示例:
     * <p>
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * <p>
     * 输出: [1,2,2,3,5,6]
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = nums1.length - 1; i >= 0 && m > 0 && n > 0; i--) {
            if (nums2[n - 1] > nums1[m - 1]) {
                nums1[i] = nums2[n - 1];
                n--;

            } else {
                nums1[i] = nums1[m - 1];
                nums1[m - 1] = nums2[n - 1];
                m--;
            }
        }
        return nums1;
    }

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * <p>
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: "race a car"
     * 输出: false
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        if (null == s || s.length() == 0) {
            return true;
        }

        char[] chars = s.trim().toUpperCase().toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(chars[i])) {
                i++;
            } else if (!Character.isLetterOrDigit(chars[j])) {
                j--;
            } else {
                if (chars[i] != chars[j]) {
                    return false;
                } else {
                    i++;
                    j--;
                }

            }

        }

        return true;
    }

    public static void main(String[] args) {
        //        System.out.println(findOne2(new int[] { 2, 1, 1, 3, 3 }));
        //        System.out.println(1 ^ 1);
        //        System.out.println(searchMatrix(new int[][] {}, 1));
        int[] nums1 = { 0 };
        int[] nums2 = { 1 };
        merge(nums1, 0, nums2, 1);
        Arrays.stream(nums1).forEach((i) -> System.out.print(i + ","));

        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    /**
     * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
     * <p>
     * 返回 s 所有可能的分割方案。
     * <p>
     * 示例:
     * <p>
     * 输入: "aab"
     * 输出:
     * [
     * ["aa","b"],
     * ["a","a","b"]
     * ]
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        if (null == s || s.length() == 0) {
            return null;
        }
        List<List<String>> lists = new ArrayList<>();
        String[] split = s.split("");
        return lists;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }



}
