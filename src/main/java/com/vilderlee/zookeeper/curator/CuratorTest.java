package com.vilderlee.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.util.function.Function;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/10/24      Create this file
 * </pre>
 */
public class CuratorTest {

    public static void main(String[] args) throws Exception{
        CuratorFramework curatorFramework = CuratorFrameworkFactory
                .builder()
                .connectString("49.234.234.31:2181")
                .retryPolicy(new ExponentialBackoffRetry(3000, 3, 1))
                .namespace("DefaultZookeeper").build();


        curatorFramework.start();

//        createPersistNode(curatorFramework, "/PersistNode");
        createEphemeralNode(curatorFramework, "/EphemeralNode");


        System.in.read();
//        curatorFramework.close();
    }

    /**
     * 生成持久化节点
     * @param client 客户端
     * @param path 地址
     */
    private static void createPersistNode(CuratorFramework client, String path) throws Exception {
        client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(path);
    }


    /**
     * 生成临时节点
     * @param client 客户端
     * @param path 地址
     */
    private static void createEphemeralNode(CuratorFramework client, String path) throws Exception {
        client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(path);
    }
}
