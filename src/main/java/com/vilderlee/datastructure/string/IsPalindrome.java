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

    public static void isPalindrome(String s){
        s.replaceAll("[^A-Za-z0-9]", "");
        s.length();
    }

    public static void main(String[] args) {
        System.out.println("A man, a plan, a canal: Panama".replaceAll("[^A-Za-z0-9]", ""));
    }
}
