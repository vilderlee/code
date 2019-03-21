package com.vilderlee.rpc;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.CountDownLatch;

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
public class ConsumerFactory {

    public static Object refer(Class interfaceClass) {
        return Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[] { interfaceClass },
                (Object proxy, Method method, Object[] args) -> {

                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    ChildChannel childChannel = new ChildChannel(countDownLatch);
                    Client client = new Client(childChannel);
                    client.connection();

                    URL url = new URL();
                    url.setMethodName(method.getName());
                    url.setParameterTypes(method.getParameterTypes());
                    url.setObjects(args);

                    client.write(url);
                    countDownLatch.await();
                    Object o = childChannel.getObject();
                    client.close();
                    return o;
                });
    }
}
