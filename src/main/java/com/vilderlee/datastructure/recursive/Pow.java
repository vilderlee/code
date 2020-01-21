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
public class Pow {

    public static int pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n < 1) {
            x = 1 / x;
            n = -n;
        }

        //判断x的奇数偶数
        if ((n & 1) == 1) {
            return x * pow(x, n / 2) * pow(x, n / 2);
        } else {
            return pow(x, n / 2) * pow(x, n / 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(5 & 1);
        System.out.println(pow(2, 4));
    }
}
