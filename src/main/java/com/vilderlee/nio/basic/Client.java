package com.vilderlee.nio.basic;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/14      Create this file
 * </pre>
 */
public class Client {

    public static void main(String[] args) {
        MultiClient client = new MultiClient(null,9999);
        new Thread(client).start();
    }
}
