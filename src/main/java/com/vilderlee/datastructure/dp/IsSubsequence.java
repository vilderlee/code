package com.vilderlee.datastructure.dp;

/**
 * 类说明:
 * <p>
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * <p>
 * 返回 true.
 * <p>
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * <p>
 * 返回 false.
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2020/1/21      Create this file
 * </pre>
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];
        dp[0][0] = true;

        for (int i = 0; i < t.length(); i++) {
            dp[0][i] = true;
        }

        for (int i = 1; i < s.length(); i++) {
            for (int j = i; j < t.length(); j++) {
                if (s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
