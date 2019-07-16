package com.vilderlee.system;

import java.util.Properties;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/15      Create this file
 * </pre>
 */
public class SystemTest {
    public static void main(String[] args) {
        Properties properties =  System.getProperties();
        properties.forEach((K,V)->{
            System.out.println(K +  "," + V);
        });
    }
}
