package com.vilderlee.gc;

/**
 * 功能描述:
 *
 * @package com.vilderlee.gc
 * @auther vilderlee
 * @date 2019-06-20 22:20
 */
public class GcTest {

    public static void main(String[] args) {


            "".substring(1,10);

        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());


        System.out.println(GcTest.class.getClassLoader());
        System.out.println(GcTest.class.getClassLoader().getParent());
        System.out.println(GcTest.class.getClassLoader().getParent().getParent());

    }
}