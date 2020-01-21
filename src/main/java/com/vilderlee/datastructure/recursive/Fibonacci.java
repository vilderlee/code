package com.vilderlee.datastructure.recursive;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2020/1/14      Create this file
 * </pre>
 */
public class Fibonacci {

    public static int fibonacci1(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }
        return fibonacci1(x - 1) + fibonacci1(x - 2);
    }

    public static int fibonacci2(int x){
        if (x == 1 || x == 2) {
            return 1;
        }
        int x1 = 1;
        int x2 = 1;
        int result = 0;
        int n = 2;
        while (n <x) {
            result = x1 + x2;
            x1 = x2;
            x2 = result;
            n++;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(fibonacci1(10));
        System.out.println(fibonacci2(10));
    }
}
