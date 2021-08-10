package com.vilderlee.datastructure.string;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/4/4      Create this file
 * </pre>
 */
public class IsPalindrome {

    public static String isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                break;
            }
        }
        return s.substring(left , right);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("aba"));
    }

}
