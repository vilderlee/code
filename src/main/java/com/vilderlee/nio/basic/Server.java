package com.vilderlee.nio.basic;

import java.io.IOException;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/2/12      Create this file
 * </pre>
 */
public class Server {

    public static void main(String[] args) throws IOException {
        MultiTimeServer server = new MultiTimeServer(9999);
        new Thread(server).start();
    }
}
