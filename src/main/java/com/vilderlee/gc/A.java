package com.vilderlee.gc;

/**
 * A
 *
 * @ClassName A
 * @Description
 * @Author VilderLee
 * @Date 2021/2/25 4:04 下午
 */

public class A extends B {

    public static int val = 3;

    static {
        System.out.println("This is A");
    }

}

class InitClass {
    public static void main(String[] args) {
        System.out.println(A.val);
    }
}
