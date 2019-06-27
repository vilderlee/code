package com.vilderlee.zookeeper.zkclient;

import com.alibaba.dubbo.common.utils.ConcurrentHashSet;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
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
public class ZkClientListenTest {

    public static final ConcurrentHashSet servers = new ConcurrentHashSet<>();


    public static void main(String[] args) throws Exception {
        ZkClient zkClient = new ZkClient("39.104.159.18:2181", 10000000);
        ZKListen zkListen = new ZKListen(zkClient);

        ExecutorService service = Executors.newFixedThreadPool(4);
        service.execute(zkListen);
    }





}
