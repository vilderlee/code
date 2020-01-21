package com.vilderlee.datastructure.string;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 类说明:
 * <p>
 * <p>
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2020/1/21      Create this file
 * </pre>
 */
public class WordBreak {

    /**
     * 暴力破解
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        return check(s, 0, wordDict);
    }

    public static boolean check(String s, int start, List<String> wordDict) {
        if (s.length() == start) {
            return true;
        }
        for (int i = start; i < s.length(); i++) {
            if (wordDict.contains(s.substring(start, i + 1)) && check(s, i + 1, wordDict)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 动态规划
     *
     * @return
     */
    public static boolean wordBreak2(String s, List<String> wordDict) {

        //对于每一个可分割字符串是不是都应该满足属于该字典
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        //思路：如果i是字符串的长度，j是分隔符位置，如果dp[j]（也就是0，j）是属于字典表的话，
        // 其j到i之间的词也属于字典表，那么当前位置就是true
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，
     * 使得句子中所有的单词都在词典中。返回所有这些可能的句子。
     * <p>
     * 说明：
     * <p>
     * 分隔时可以重复使用字典中的单词。
     * 你可以假设字典中没有重复的单词。
     * 示例 1：
     * <p>
     * 输入:
     * s = "catsanddog"
     * wordDict = ["cat", "cats", "and", "sand", "dog"]
     * 输出:
     * [
     * "cats and dog",
     * "cat sand dog"
     * ]
     * 示例 2：
     * <p>
     * 输入:
     * s = "pineapplepenapple"
     * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
     * 输出:
     * [
     * "pine apple pen apple",
     * "pineapple pen apple",
     * "pine applepen apple"
     * ]
     * 解释: 注意你可以重复使用字典中的单词。
     * 示例 3：
     * <p>
     * 输入:
     * s = "catsandog"
     * wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出:
     * []
     */
    public static List<String> wordBreakII(String s, List<String> wordDict) {
        LinkedList<String>[] dp = new LinkedList[s.length() + 1];
        LinkedList<String> initial = new LinkedList<>();
        initial.add("");
        dp[0] = initial;

        for (int i = 1; i <= s.length(); i++) {
            LinkedList list = new LinkedList();
            for (int j = 0; j < i; j++) {
                if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
                    for (String l:dp[j]) {
                        list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
                    }
                }
                dp[i] = list;
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(wordBreakII("leetcode", Arrays.asList("leet", "code", "sand", "and", "cat")));
    }
}
