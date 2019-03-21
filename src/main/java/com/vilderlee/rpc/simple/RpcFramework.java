package com.vilderlee.rpc.simple;

import com.vilderlee.rpc.URL;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
public class RpcFramework {

    private static ZooKeeper zkClient;

    public static void export(Object service, Class serviceInterface) throws Exception {
        if (service == null) {
            System.out.println("service is not null!");
        }

        //将服务注册到zk上
        initZk();

        Stat stat = zkClient.exists("/simpleRPC",false);
        if (null == stat) {
            zkClient.create("/simpleRPC", null,
                    ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.PERSISTENT);
            Stat childStat = zkClient.exists("/simpleRPC/" + serviceInterface.getName(), false);
            if (null == childStat){
                zkClient.create("/simpleRPC/" + serviceInterface.getName(), "127.0.0.1:9999".getBytes(),
                        ZooDefs.Ids.OPEN_ACL_UNSAFE,
                        CreateMode.PERSISTENT);
            }
        }
        ServerSocket serverSocket = new ServerSocket(9999);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (; ; ) {
            Socket socket = serverSocket.accept();
            Runnable runnable = () -> {
                ObjectInputStream objectInputStream = null;
                ObjectOutputStream objectOutputStream = null;
                try {
                    objectInputStream = new ObjectInputStream(socket.getInputStream());
                    URL url = (URL) objectInputStream.readObject();
                    //调用方法的名称
                    String methodName = url.getMethodName();
                    //调用方法参数类型
                    Class[] classes = url.getParameterTypes();
                    //调用方法参数
                    Object[] objects = url.getObjects();

                    //获取调用方法
                    Method method = service.getClass().getMethod(methodName, classes);
                    //调用方法执行
                    Object result = method.invoke(service, objects);
                    objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                    objectOutputStream.writeObject(result);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        objectInputStream.close();
                        objectOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            };
            executor.execute(runnable);
        }
    }

    public static void initZk() throws Exception {
        zkClient = new ZooKeeper("39.104.159.18:2181", 10000000, new Watcher() {
            @Override public void process(WatchedEvent event) {
                System.out.println(event.getType() + "---" + event.getPath());
                try {
                    zkClient.getChildren("/", true);
                } catch (Exception e) {
                }
            }
        });
    }

    public static Object refer(Class service, String hostname, int port) throws Exception {

        initZk();
        byte[] bytes = zkClient.getData("/simpleRPC/" + service.getName(), true, null);
        String s = new String(bytes);
        String[] s1 = s.split(":");
        Socket socket = new Socket(s1[0], Integer.valueOf(s1[1]));
        return Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[] { service },
                (Object proxy, Method method, Object[] args) -> {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

                    //组装数据
                    URL url = new URL();
                    url.setInterfaceClass(service.getName());
                    url.setMethodName(method.getName());
                    url.setParameterTypes(method.getParameterTypes());
                    url.setObjects(args);

                    objectOutputStream.writeObject(url);
                    ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

                    return inputStream.readObject();
                });
    }

}
