package com.vilderlee.datastructure.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 类说明:
 * <p>
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
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2020/1/21      Create this file
 * </pre>
 */
public class PartitionString {

    /**
     * 分治
     *
     * @param s
     * @return
     */
    public static List<List<String>> partition(String s) {

        return part(s, 0);
    }

    public static List<List<String>> part(String s, int start) {
        if (s.length() == start) {
            List<String> list = new ArrayList<>();
            List<List<String>> ans = new ArrayList<>();
            ans.add(list);
            return ans;

        }
        List<List<String>> res = new ArrayList<>();

        for (int i = start; i < s.length(); i++) {
            if (isPar(s, start, i)) {
                String left = s.substring(start, i + 1);
                for (List<String> list : part(s, i + 1)) {
                    list.add(0, left);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public static boolean isPar(String s, int start, int end) {

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;

    }

    public static void main(String[] args) {
        List<List<String>> aab = partition("aab");
        System.out.println();
    }

}
