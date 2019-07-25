package com.vilderlee.zookeeper.zkclient;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;

class ZKListen implements Runnable {

    public ZKListen(ZkClient zkClient) {
        this.zkClient = zkClient;
    }

    private ZkClient zkClient;

    @Override public void run() {
        zkClient.subscribeChildChanges("/test20190627", new IZkChildListener() {
            @Override public void handleChildChange(String parentPath, List<String> currentChild) throws Exception {
                System.out.println("------" + parentPath + "------");
                System.out.println("******" + currentChild + "******");
                currentChild.forEach(child -> {
                    String data = zkClient.readData("/test20190627/" + child);
                    if (!ZkClientListenTest.servers.contains(data)) {
                        ZkClientListenTest.servers.add(data);
                    }
                });
            }
        });
    }
}