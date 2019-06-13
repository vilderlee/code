package com.vilderlee.zookeeper;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;
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
public class ZkClientTest {

    public static void main(String[] args) throws Exception {
        ZkClient zkClient = new ZkClient("39.104.159.18:2181",10000000);

        zkClient.subscribeChildChanges("/test", new IZkChildListener() {
            @Override public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
                System.out.println("------" + parentPath + "------");
                System.out.println("******" + currentChilds + "******");
            }
        });
        Thread.sleep(3000);

        zkClient.createEphemeral("/test/test-ch1","vilderlee");
        TimeUnit.SECONDS.sleep(1000);

        zkClient.delete("/test/test-ch1");

        zkClient.close();
    }
}
