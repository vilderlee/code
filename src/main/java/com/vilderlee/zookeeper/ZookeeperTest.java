package com.vilderlee.zookeeper;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/21      Create this file
 * </pre>
 */
public class ZookeeperTest {

    private static ZooKeeper zkClient;
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {

        zkClient = new ZooKeeper("39.104.159.18:2181", 10000000, new DefaultWatcher());
//        countDownLatch.await();

        System.out.println("Zookeeper Session is established!");

        Stat stat = zkClient.exists("/test", true);
        if (stat != null) {
            zkClient.create("/test/com.vilderlee/test1", "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.EPHEMERAL);
        }

        List<String> childList = zkClient.getChildren("/test", new ChildWatcher());
        //        zkClient.getData("/test",true,stat);
        //        zkClient.setData("/test","lichao".getBytes(),1);

        childList.forEach(s -> System.out.println("-----" + s ));

        TimeUnit.MINUTES.sleep(10);
    }

    static class DefaultWatcher implements Watcher{

        @Override
        public void process(WatchedEvent event) {

            System.out.println("==========DefaultWatcher start==============");

            System.out.println("DefaultWatcher state: " + event.getState().name());

            System.out.println("DefaultWatcher type: " + event.getType().name());

            System.out.println("DefaultWatcher path: " + event.getPath());

            System.out.println("==========DefaultWatcher end==============");

//            countDownLatch.countDown();
        }
    }


    static class ChildWatcher implements Watcher{
        @Override
        public void process(WatchedEvent event) {

            System.out.println("==========ChildWatcher start==============");

            System.out.println("ChildWatcher state: " + event.getState().name());

            System.out.println("ChildWatcher type: " + event.getType().name());

            System.out.println("ChildWatcher path: " + event.getPath());

            System.out.println("==========ChildWatcher end==============");
        }
    }
}
