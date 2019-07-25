package com.vilderlee.switcht;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/6/20      Create this file
 * </pre>
 */
public class Switch {
    public static void main(String[] args) {
        String test = "";

        switch (test) {
        case "null":
            System.out.println("it is null");
            break;
        case "":
            System.out.println("this is empty");
            break;
        default:
            System.out.println("it is xxx");

        }

    }
}
