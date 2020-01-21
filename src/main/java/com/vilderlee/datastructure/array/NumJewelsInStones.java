package com.vilderlee.datastructure.array;

import java.util.HashSet;
import java.util.Set;

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.
 * You want to know how many of the stones you have are also jewels.
 * <p>
 * The letters in J are guaranteed distinct,
 * and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 * <p>
 * Input: J = "z", S = "ZZ"
 * Output: 0
 */
public class NumJewelsInStones {

    /**
     * 第一种解法：双循环遍历
     *
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        int count = 0;

        char[] jChars = J.toCharArray();
        char[] sChars = S.toCharArray();

        for (int i = 0; i < sChars.length; i++) {
            char tem = sChars[i];
            for (int j = 0; j < jChars.length; j++) {
                char jtem = jChars[j];
                if (tem == jtem) {
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * 第二种解法：已知宝石种类肯定为不重复的，那么将其放入set中去处理
     *
     *  这种解法运算更快
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones2(String J, String S) {
        int count = 0;
        Set set = new HashSet();
        char[] sChars = S.toCharArray();
        for (char c: J.toCharArray()) {
            set.add(c);
        }

        for (int i = 0; i < sChars.length; i++) {
            if (set.contains(sChars[i])){
                count++;
            }
        }


        return count;

    }

    public static void main(String[] args) {
        NumJewelsInStones solution = new NumJewelsInStones();
        System.out.println(solution.numJewelsInStones2("aA", "aAAbbbb"));
    }
}
