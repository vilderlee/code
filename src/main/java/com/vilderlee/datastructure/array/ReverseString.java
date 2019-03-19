package com.vilderlee.datastructure.array;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/11      Create this file
 * </pre>
 */
public class ReverseString {
    public void reverseString(String string) {
        char[] s = string.toCharArray();
        char[] f = new char[s.length];
        for (int i = 0; i < s.length; i++) {
            f[s.length - i - 1] = s[i];
        }

    }

    public static void main(String[] args) {
        ReverseString string = new ReverseString();
        string.reverseString("hello");
    }
}
