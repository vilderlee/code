package com.vilderlee.zookeeper.zkclient;

import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.TimeUnit;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/5/5      Create this file
 * </pre>
 */
public class ZkServerTest {

    public static void main(String[] args) throws Exception {
        ZkClient zkClient = new ZkClient("39.104.159.18:2181", 10000000);
        boolean isExist = zkClient.exists("/test20190627");
        if (isExist) {
            createNode(zkClient);
            TimeUnit.MINUTES.sleep(10);
        }
    }

    private static void createNode(ZkClient zkClient) {
        zkClient.createEphemeral("/test20190627/Client2", "192.168.31.2");
    }

}
