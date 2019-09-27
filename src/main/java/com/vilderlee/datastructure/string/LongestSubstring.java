package com.vilderlee.datastructure.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 类说明:
 * Given a string, find the length of the longest substring without repeating characters.
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/9/4      Create this file
 * </pre>
 */
public class LongestSubstring {

    public static int subStringValue(String s) {
        Set<Character> set = new HashSet<>();

        int i = 0, j = 0, ans = 0;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(subStringValue("abcabcbb"));
    }
}
